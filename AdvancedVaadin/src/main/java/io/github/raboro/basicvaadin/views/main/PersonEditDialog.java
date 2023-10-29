package io.github.raboro.basicvaadin.views.main;

import com.vaadin.flow.component.notification.Notification;
import io.github.raboro.basicvaadin.controller.PersonController;
import io.github.raboro.basicvaadin.data.model.Person;

import java.util.Optional;

/**
 * @author MariusWoerfel
 */
public class PersonEditDialog extends PersonDialog {

    private final transient Person person;

    PersonEditDialog(PersonController controller, Runnable updateGrid, Person person) {
        super("Edit Person", controller, updateGrid);
        this.person = person;
        setHeaderTitle("Edit Person");
        setWidth("30%");
        setPlaceholders();
    }

    private void setPlaceholders() {
        nameField.setValue(person.getName());
        emailField.setValue(person.getEmail());
        ageField.setValue(String.valueOf(person.getAge()));
        vacationDaysField.setValue(String.valueOf(person.getVacationDays()));
    }

    @Override
    protected void saveNonEmptyPerson() {
        Optional<String> error = controller.validatePerson(ageField.getValue(), vacationDaysField.getValue());
        error.ifPresentOrElse(Notification::show, () -> {
                    controller.updatePerson(person, nameField.getValue(), emailField.getValue(), ageField.getValue(), vacationDaysField.getValue());
                    close();
                    updateGrid.run();
                }
        );
    }
}