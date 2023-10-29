package io.github.raboro.basicvaadin.views.main;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import io.github.raboro.basicvaadin.controller.PersonController;
import io.github.raboro.basicvaadin.security.SecurityService;
import io.github.raboro.basicvaadin.views.header.HeaderView;
import jakarta.annotation.security.PermitAll;

@PermitAll
@PageTitle("Main")
@Route("")
public class MainView extends AppLayout {

    public MainView(SecurityService securityService, PersonController controller) {
        setPrimarySection(Section.DRAWER);
        addToNavbar(true, new HeaderView(securityService));
        constructContent(controller);
    }

    private void constructContent(PersonController controller) {
        Div content = new Div();
        content.getStyle().setPadding("10%");
        PersonGrid personGrid = new PersonGrid(controller);
        content.add(personGrid);
        Button addButton = new Button("Add", e -> new PersonAddDialog(controller, personGrid::update).open());
        addButton.getStyle().set("margin-left", "46%");
        addButton.getStyle().set("margin-top", "10%");
        addButton.getStyle().setWidth("10%");
        content.add(addButton);
        setContent(content);
    }

}
