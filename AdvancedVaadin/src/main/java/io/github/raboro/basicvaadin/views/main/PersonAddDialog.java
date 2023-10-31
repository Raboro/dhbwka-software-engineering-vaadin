package io.github.raboro.basicvaadin.views.main;

import com.vaadin.flow.component.notification.Notification;
import io.github.raboro.basicvaadin.controller.PersonController;

import java.util.Optional;

/**
 * @author MariusWoerfel
 */
public class PersonAddDialog extends PersonDialog {

    PersonAddDialog(PersonController controller, Runnable updateGrid) {
        super("Add Person", controller, updateGrid);
    }

    @Override
    protected void saveNonEmptyPerson() {
        Optional<String> error = controller.validatePerson(ageField.getValue(), vacationDaysField.getValue());
        error.ifPresentOrElse(Notification::show, () -> {
                    controller.savePerson(
                            nameField.getValue(),
                            emailField.getValue(),
                            ageField.getValue(),
                            vacationDaysField.getValue()
                    );
                    close();
                    updateGrid.run();
                }
        );
    }
}