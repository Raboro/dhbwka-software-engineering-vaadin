package io.github.raboro.basicvaadin.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import io.github.raboro.basicvaadin.controller.PersonController;
import io.github.raboro.basicvaadin.data.model.Person;

import java.util.Optional;

import static com.vaadin.flow.component.button.ButtonVariant.*;

/**
 * @author MariusWoerfel
 */
public class PersonGrid extends Grid<Person> {

    private final transient PersonController controller;

    PersonGrid(PersonController controller) {
        super(Person.class, false);
        this.controller = controller;
        this.constructColumns();
        this.handleSelectionListener();
        this.setItems(this.controller.getAllPersons());
    }

    private void constructColumns() {
        this.addBasicColumns();
        this.addBadgeColumn();
        this.addDeleteColumn();
        this.addEditColumn();
    }

    private void addBasicColumns() {
        this.addColumn(Person::getName)
                .setHeader("Name")
                .setFooter("Total Persons: " + controller.getAllPersons().size())
                .setTextAlign(ColumnTextAlign.CENTER)
                .setSortable(true);
        this.addColumn(Person::getAge)
                .setHeader("Age")
                .setFooter("Average Age: " + controller.averageAgeOfAllPersons())
                .setTextAlign(ColumnTextAlign.CENTER)
                .setSortable(true);
        this.addColumn(Person::getVacationDays)
                .setHeader("Vacation Days")
                .setFooter("Total Vacation Days: " + controller.countVacationDaysOfAllPersons())
                .setTextAlign(ColumnTextAlign.CENTER)
                .setSortable(true);
    }

    private void addBadgeColumn() {
        this.addColumn(new ComponentRenderer<>(Span::new, (span, person) -> {
                    final boolean moreThenOneVacationDay = person.getVacationDays() > 0;
                    span.getElement().getThemeList().add("badge " + (moreThenOneVacationDay ? "success" : "error"));
                    span.getElement().setText(moreThenOneVacationDay ? "Remaining" : "Done");
                })
        ).setHeader("Vacation Status").setWidth("0.5%").setTextAlign(ColumnTextAlign.CENTER).setSortable(true);
    }

    private void addDeleteColumn() {
        this.addColumn(new ComponentRenderer<>(Button::new, (button, person) -> {
                    button.addThemeVariants(LUMO_ICON, LUMO_ERROR, LUMO_TERTIARY);
                    button.addClickListener(e -> new PersonDeleteDialog(person.getName(), () -> {
                        controller.deletePerson(person);
                        update();
                    }).open());
                    button.setIcon(new Icon(VaadinIcon.TRASH));
                })
        ).setHeader("Delete").setWidth("0.5%").setTextAlign(ColumnTextAlign.CENTER);
    }

    private void addEditColumn() {
        this.addColumn(new ComponentRenderer<>(Button::new, (button, person) -> {
            button.addThemeVariants(LUMO_ICON, LUMO_TERTIARY);
            button.addClickListener(e -> new PersonEditDialog(controller, this::update, person).open());
            button.setIcon(new Icon(VaadinIcon.EDIT));
        })).setHeader("Edit").setWidth("0.5%").setTextAlign(ColumnTextAlign.CENTER);
    }

    private void handleSelectionListener() {
        this.addSelectionListener(selection -> {
            Optional<Person> element = selection.getFirstSelectedItem();
            element.ifPresent(person -> new PersonEditDialog(controller, this::update, person).open());
        });
    }

    public void update() {
        this.setItems(this.controller.getAllPersons());
        this.removeAllColumns();
        this.constructColumns();
        Notification.show("Updated Columns", 1000, Notification.Position.TOP_END);
    }
}