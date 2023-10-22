package io.github.raboro.basicvaadin.views.main;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import io.github.raboro.basicvaadin.security.SecurityService;
import jakarta.annotation.security.PermitAll;

@PermitAll
@PageTitle("Main")
@Route("")
public class MainView extends HorizontalLayout {

    private final SecurityService securityService;
    private TextField name;
    private Button sayHello;

    public MainView(SecurityService securityService) {
        this.securityService = securityService;
        name = new TextField("Your name");
        sayHello = new Button("Say hello");
        sayHello.addClickListener(e -> Notification.show("Hello " + name.getValue()));
        sayHello.addClickShortcut(Key.ENTER);

        Button logout = new Button("Logout", e -> this.securityService.logout());

        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, name, sayHello, logout);

        add(name, sayHello, logout);
    }

}
