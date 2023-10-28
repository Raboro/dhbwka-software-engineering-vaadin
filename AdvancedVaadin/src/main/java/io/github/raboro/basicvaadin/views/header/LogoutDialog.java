package io.github.raboro.basicvaadin.views.header;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import io.github.raboro.basicvaadin.security.SecurityService;

/**
 * @author MariusWoerfel
 */
public class LogoutDialog extends Dialog {

    public LogoutDialog(SecurityService securityService) {
        setHeaderTitle("Logout");
        add("Are you sure to logout?");
        Button cancelButton = new Button("Cancel", e -> close());
        Button logoutButton = new Button("Logout", e -> securityService.logout());
        logoutButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
        getFooter().add(cancelButton, logoutButton);
    }
}