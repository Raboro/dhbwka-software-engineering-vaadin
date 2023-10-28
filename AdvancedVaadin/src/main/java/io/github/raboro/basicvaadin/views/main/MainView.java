package io.github.raboro.basicvaadin.views.main;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
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
        content.getStyle().set("padding", "10%");
        content.add(new PersonGrid(controller));
        setContent(content);
    }

}
