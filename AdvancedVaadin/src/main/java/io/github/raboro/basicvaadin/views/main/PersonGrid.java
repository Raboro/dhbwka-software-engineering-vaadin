package io.github.raboro.basicvaadin.views.main;

import com.vaadin.flow.component.grid.Grid;
import io.github.raboro.basicvaadin.controller.PersonController;
import io.github.raboro.basicvaadin.data.model.Person;

/**
 * @author MariusWoerfel
 */
public class PersonGrid extends Grid<Person> {

    private final PersonController controller;

    PersonGrid(PersonController controller) {
        super(Person.class, false);
        this.controller = controller;
        constructColumns();
        setItems(this.controller.getAllPersons());
    }

    private void constructColumns() {
        addColumn(Person::getName)
                .setHeader("Name")
                .setFooter("Total Persons: " + controller.getAllPersons().size());
        addColumn(Person::getAge)
                .setHeader("Age")
                .setFooter("Average Age: " + controller.averageAgeOfAllPersons());
        addColumn(Person::getHolidayDays)
                .setHeader("HolidayDays")
                .setFooter("Total Holiday Days: " + controller.countHolidayDaysOfAllPersons());
    }
}