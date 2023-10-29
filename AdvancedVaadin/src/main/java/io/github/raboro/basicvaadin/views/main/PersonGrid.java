package io.github.raboro.basicvaadin.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.data.renderer.ComponentRenderer;
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
        addColumn(new ComponentRenderer<>(Span::new, (span, person) -> {
            if (person.getHolidayDays() > 0) {
                span.getElement().getThemeList().add("badge success");
                span.getElement().setText("Remaining");
            } else {
                span.getElement().getThemeList().add("badge error");
                span.getElement().setText("Done");
            }
        })).setHeader("Holiday Status").setWidth("0.5%");
        addColumn(new ComponentRenderer<>(Button::new, (button, person) -> {
            button.addThemeVariants(ButtonVariant.LUMO_ICON,
                    ButtonVariant.LUMO_ERROR,
                    ButtonVariant.LUMO_TERTIARY);
            button.addClickListener(e -> Notification.show("Delete"));
            button.setIcon(new Icon(VaadinIcon.TRASH));
        })).setHeader("Delete").setWidth("0.5%");
        addColumn(new ComponentRenderer<>(Button::new, (button, person) -> {
            button.addThemeVariants(ButtonVariant.LUMO_ICON,
                    ButtonVariant.LUMO_TERTIARY);
            button.addClickListener(e -> Notification.show("Edit"));
            button.setIcon(new Icon(VaadinIcon.EDIT));
        })).setHeader("Edit").setWidth("0.5%");
    }

    public void update() {
        setItems(this.controller.getAllPersons());
        removeAllColumns();
        constructColumns();
    }
}