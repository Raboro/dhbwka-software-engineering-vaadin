package io.github.raboro.basicvaadin.views.header;

import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import io.github.raboro.basicvaadin.security.SecurityService;

/**
 * @author MariusWoerfel
 */
public class HeaderView extends HorizontalLayout {

    public HeaderView(SecurityService securityService) {
        constructConfig();
        addData(securityService);
    }

    private void constructConfig() {
        setId("header");
        setWidthFull();
        setSpacing(true);
        setAlignItems(Alignment.CENTER);
    }

    private void addData(SecurityService securityService) {
        H1 title = new H1("Overview");
        title.getStyle().set("margin-left", "42%");
        Button logoutButton = new Button("Logout", e -> new LogoutDialog(securityService).open());
        logoutButton.getStyle().set("margin-left", "auto");
        logoutButton.getStyle().set("margin-right", "3%");
        Avatar avatar = new Avatar(securityService.getAuthenticatedUser().getUsername());
        avatar.getStyle().set("margin-right", "2%");
        avatar.setTooltipEnabled(true);
        add(new DrawerToggle(), title, logoutButton, avatar);
    }
}