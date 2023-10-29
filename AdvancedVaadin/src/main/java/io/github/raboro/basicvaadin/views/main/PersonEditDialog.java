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
import io.github.raboro.basicvaadin.data.model.Person;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author MariusWoerfel
 */
public class PersonEditDialog extends Dialog {

    private final Person person;
    private final PersonController controller;
    private final TextField nameField = new TextField("Name");
    private final EmailField emailField = new EmailField("Email");
    private final TextField ageField = new TextField("Age");
    private final TextField holidayDaysField = new TextField("HolidayDays");
    private final TextFieldBase[] fields = new TextFieldBase[]{ nameField, emailField, ageField, holidayDaysField };
    private final Runnable updateGrid;

    PersonEditDialog(PersonController controller, Runnable updateGrid, Person person) {
        this.person = person;
        this.controller = controller;
        this.updateGrid = updateGrid;
        setHeaderTitle("Edit Person");
        setWidth("30%");
        setPlaceholders();
        add(constructContent());
        constructFooter();
    }

    private void setPlaceholders() {
        nameField.setValue(person.getName());
        emailField.setValue(person.getEmail());
        ageField.setValue(String.valueOf(person.getAge()));
        holidayDaysField.setValue(String.valueOf(person.getHolidayDays()));
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
        Button saveButton = new Button("Edit", this::updatePerson);
        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        getFooter().add(cancelButton, saveButton);
    }


    private void updatePerson(ClickEvent<Button> buttonClickEvent) {
        for (TextFieldBase field : fields) {
            if (field.isEmpty()) {
                Notification.show("Field: \"%s\" is empty".formatted(field.getLabel()));
                return;
            }
        }
        updateNonEmptyPerson();
    }

    private void updateNonEmptyPerson() {
        Optional<String> error = controller.validatePerson(ageField.getValue(), holidayDaysField.getValue());
        error.ifPresentOrElse(Notification::show, () -> {
                    controller.updatePerson(person, nameField.getValue(), emailField.getValue(), ageField.getValue(), holidayDaysField.getValue());
                    close();
                    updateGrid.run();
                }
        );
    }
}