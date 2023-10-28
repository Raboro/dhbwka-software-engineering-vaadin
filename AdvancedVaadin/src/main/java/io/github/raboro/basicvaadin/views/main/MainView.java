package io.github.raboro.basicvaadin.views.main;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import io.github.raboro.basicvaadin.controller.PersonController;
import io.github.raboro.basicvaadin.data.model.Person;
import io.github.raboro.basicvaadin.security.SecurityService;
import io.github.raboro.basicvaadin.views.header.HeaderView;
import jakarta.annotation.security.PermitAll;

@PermitAll
@PageTitle("Main")
@Route("")
public class MainView extends AppLayout {

    private final SecurityService securityService;
    private final PersonController controller;

    public MainView(SecurityService securityService, PersonController controller) {
        this.controller = controller;
        this.securityService = securityService;
        setPrimarySection(Section.DRAWER);
        addToNavbar(true, new HeaderView(securityService));

        Div content = new Div();
        content.getStyle().setPadding("10%");
        content.add(new PersonGrid(controller));

        Button addButton = new Button("Add", e -> Notification.show("Add"));
        addButton.getStyle().set("margin-left", "46%");
        addButton.getStyle().set("margin-top", "10%");
        addButton.getStyle().setWidth("10%");
        content.add(addButton);
        setContent(content);
    }

}
