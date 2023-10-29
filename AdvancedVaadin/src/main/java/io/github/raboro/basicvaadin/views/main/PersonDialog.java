package io.github.raboro.basicvaadin.views.main;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
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

/**
 * @author MariusWoerfel
 */
public abstract class PersonDialog extends Dialog {

    protected final transient PersonController controller;
    protected final transient Runnable updateGrid;
    protected final TextField nameField = new TextField("Name");
    protected final EmailField emailField = new EmailField("Email");
    protected final TextField ageField = new TextField("Age");
    protected final TextField vacationDaysField = new TextField("Vacation Days");
    protected final TextFieldBase<TextField, String>[] fields = new TextFieldBase[]{ nameField, emailField, ageField, vacationDaysField };

    PersonDialog(String title, PersonController controller, Runnable updateGrid) {
        this.updateGrid = updateGrid;
        this.controller = controller;
        setHeaderTitle(title);
        setWidth("30%");
        add(constructContent());
        constructFooter();
    }

    private VerticalLayout constructContent() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(nameField, emailField, ageField, vacationDaysField);
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

    protected abstract void saveNonEmptyPerson();
}
