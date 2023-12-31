package io.github.raboro.basicvaadin.controller;

import io.github.raboro.basicvaadin.data.model.Person;
import io.github.raboro.basicvaadin.data.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author MariusWoerfel
 */
@Controller
public class PersonController {

    private final PersonRepository repository;

    @Autowired
    PersonController(PersonRepository repository) {
        this.repository = repository;
        initData();
    }

    private void initData() {
        repository.save(new Person("Mike", "Mike@gmail.com", 18, 10));
        repository.save(new Person("Ralf", "RalleRalf@gmail.com", 22, 10));
        repository.save(new Person("Ruven", "R.uvenR@gmail.com", 21, 6));
        repository.save(new Person("Peter", "Peter.P@gmail.com", 18, 5));
    }

    public List<Person> getAllPersons() {
        return repository.findAll();
    }

    public int countVacationDaysOfAllPersons() {
        return getAllPersons().stream()
                .mapToInt(Person::getVacationDays)
                .sum();
    }

    public int averageAgeOfAllPersons() {
        final List<Person> persons = getAllPersons();
        return sumOfAges(persons) / persons.size();
    }

    private int sumOfAges(List<Person> persons) {
        return persons.stream()
                .mapToInt(Person::getAge)
                .sum();
    }

    public Optional<String> validatePerson(String ageField, String vacationDaysField) {
        final Optional<String> ageCheck = isInvalid(ageField, "Age is not a number");
        return ageCheck.isPresent() ? ageCheck : isInvalid(vacationDaysField, "Vacation Days is not a number");
    }

    private Optional<String> isInvalid(String value, String errorMessage) {
        try {
            return Integer.parseInt(value) < 0 ? Optional.of("Value too low") : Optional.empty();
        } catch (NumberFormatException e) {
            return Optional.of(errorMessage);
        }
    }

    public void savePerson(String name, String email, String age, String vacationDays) {
        repository.save(new Person(name, email, Integer.parseInt(age), Integer.parseInt(vacationDays)));
    }

    public void deletePerson(Person person) {
        repository.delete(person);
    }

    public void updatePerson(Person person, String name, String email, String age, String vacationDays) {
        Optional<Person> optionalPerson = repository.findById(person.getId());
        optionalPerson.ifPresentOrElse(
                updatePerson(name, email, age, vacationDays),
                () -> repository.save(new Person(name, email, Integer.parseInt(age), Integer.parseInt(vacationDays)))
        );
    }

    private Consumer<Person> updatePerson(String name, String email, String age, String vacationDays) {
        return updatedPerson -> {
            updatedPerson.setName(name);
            updatedPerson.setEmail(email);
            updatedPerson.setAge(Integer.parseInt(age));
            updatedPerson.setVacationDays(Integer.parseInt(vacationDays));
            repository.save(updatedPerson);
        };
    }
}