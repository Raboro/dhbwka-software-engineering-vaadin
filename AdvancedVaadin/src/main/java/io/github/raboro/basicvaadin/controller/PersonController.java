package io.github.raboro.basicvaadin.controller;

import io.github.raboro.basicvaadin.data.model.Person;
import io.github.raboro.basicvaadin.data.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

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

    public int countHolidayDaysOfAllPersons() {
        return getAllPersons().stream()
                .mapToInt(Person::getHolidayDays)
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
}