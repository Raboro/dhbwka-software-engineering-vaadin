package io.github.raboro.basicvaadin.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;

/**
 * @author MariusWoerfel
 */
public class PersonDeleteDialog extends Dialog {

    public PersonDeleteDialog(String personName, Runnable delete) {
        this.setHeaderTitle("Delete Person");
        this.add("Are you sure to delete: " + personName + "?");
        this.constructFooter(delete);
    }

    private void constructFooter(Runnable delete) {
        final Button cancelButton = new Button("Cancel", e -> close());
        Button logoutButton = new Button("Delete", e -> {
            close();
            delete.run();
        });
        logoutButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
        this.getFooter().add(cancelButton, logoutButton);
    }

}