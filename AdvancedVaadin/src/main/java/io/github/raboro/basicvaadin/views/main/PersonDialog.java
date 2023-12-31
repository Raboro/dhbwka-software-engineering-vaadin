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
        this.setHeaderTitle(title);
        this.setWidth("30%");
        this.add(constructContent());
        this.constructFooter();
    }

    private VerticalLayout constructContent() {
        VerticalLayout verticalLayout = new VerticalLayout(FlexComponent.Alignment.CENTER);
        for (TextFieldBase<TextField, String> field : fields) {
            verticalLayout.add(field);
            field.setRequired(true);
        }
        return verticalLayout;
    }

    private void constructFooter() {
        Button cancelButton = new Button("Cancel", e -> close());
        Button saveButton = new Button("Save", this::savePerson);
        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        this.getFooter().add(cancelButton, saveButton);
    }

    private void savePerson(ClickEvent<Button> buttonClickEvent) {
        for (TextFieldBase<TextField, String> field : fields) {
            if (field.isEmpty()) {
                Notification.show("Field: \"%s\" is empty".formatted(field.getLabel()));
                return;
            }
        }
        this.saveNonEmptyPerson();
    }

    protected abstract void saveNonEmptyPerson();
}
