package io.github.raboro.basicvaadin.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;

/**
 * @author MariusWoerfel
 */
public class PersonDeleteDialog extends Dialog {

    public PersonDeleteDialog(String personName, Runnable delete) {
        setHeaderTitle("Delete Person");
        add("Are you suer to delete: " + personName + "?");
        Button cancelButton = new Button("Cancel", e -> close());
        Button logoutButton = new Button("Delete", e -> {
            close();
            delete.run();
        });
        logoutButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
        getFooter().add(cancelButton, logoutButton);
    }

}