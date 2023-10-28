package io.github.raboro.basicvaadin.views.main;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldBase;
import io.github.raboro.basicvaadin.controller.PersonController;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author MariusWoerfel
 */
public class PersonAddDialog extends Dialog {

    private final PersonController controller;
    private final TextField nameField = new TextField("Name");
    private final EmailField emailField = new EmailField("Email");
    private final TextField ageField = new TextField("Age");
    private final TextField holidayDaysField = new TextField("HolidayDays");
    private final TextFieldBase[] fields = new TextFieldBase[]{ nameField, emailField, ageField, holidayDaysField };
    private final Runnable updateGrid;

    PersonAddDialog(PersonController controller, Runnable updateGrid) {
        this.updateGrid = updateGrid;
        this.controller = controller;
        setHeaderTitle("Add Person");
        setWidth("30%");
        add(constructContent());
        constructFooter();
    }

    private VerticalLayout constructContent() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(nameField, emailField, ageField, holidayDaysField);
        Arrays.stream(fields).forEach(field -> field.setRequired(true));
        verticalLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        return verticalLayout;
    }

    private void constructFooter() {
        Button cancelButton = new Button("Cancel", e -> close());
        Button saveButton = new Button("Save", this::savePerson);
        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        getFooter().add(cancelButton, saveButton);
    }

    private void savePerson(ClickEvent<Button> buttonClickEvent) {
        for (TextFieldBase field : fields) {
            if (field.isEmpty()) {
                Notification.show("Field: \"%s\" is empty".formatted(field.getLabel()));
                return;
            }
        }
        saveNonEmptyPerson();
    }

    private void saveNonEmptyPerson() {
        Optional<String> error = controller.validatePerson(ageField.getValue(), holidayDaysField.getValue());
        error.ifPresentOrElse(Notification::show, () -> {
                    controller.savePerson(nameField.getValue(), emailField.getValue(), ageField.getValue(), holidayDaysField.getValue());
                    close();
                    updateGrid.run();
                }
        );
    }
}