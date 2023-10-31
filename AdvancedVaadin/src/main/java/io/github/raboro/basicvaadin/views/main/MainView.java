package io.github.raboro.basicvaadin.views.main;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import io.github.raboro.basicvaadin.controller.PersonController;
import io.github.raboro.basicvaadin.security.SecurityService;
import io.github.raboro.basicvaadin.views.header.HeaderView;
import io.github.raboro.basicvaadin.views.login.LoginView;
import jakarta.annotation.security.PermitAll;

@PermitAll
@PageTitle("Main")
@Route("")
public class MainView extends AppLayout {

    public MainView(SecurityService securityService, PersonController controller) {
        addToNavbar(new HeaderView(securityService));
        constructContent(controller);
        addToDrawer(createTabs());
    }

    private void constructContent(PersonController controller) {
        Div content = new Div();
        content.getStyle().setPadding("10%");
        PersonGrid personGrid = new PersonGrid(controller);
        content.add(personGrid);
        content.add(constructAddButton(controller, personGrid));
        setContent(content);
    }

    private Button constructAddButton(PersonController controller, PersonGrid personGrid) {
        Button addButton = new Button("Add", e -> new PersonAddDialog(controller, personGrid::update).open());
        addButton.getStyle().set("margin-left", "46%");
        addButton.getStyle().set("margin-top", "10%");
        addButton.getStyle().setWidth("10%");
        return addButton;
    }

    private Tabs createTabs() {
        Tabs tabs = new Tabs();
        tabs.add(
                createTab(VaadinIcon.DASHBOARD, "Overview", this),
                createTab(VaadinIcon.LOCK, "Login", new LoginView())
        );
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        return tabs;
    }

    private Tab createTab(VaadinIcon viewIcon, String name, Component clazz) {
        Icon icon = viewIcon.create();
        icon.getStyle().set("box-sizing", "border-box")
                .set("margin-inline-end", "var(--lumo-space-m)")
                .set("margin-inline-start", "var(--lumo-space-xs)")
                .set("padding", "var(--lumo-space-xs)");
        RouterLink link = new RouterLink();
        link.add(icon, new Span(name));
        link.setRoute(clazz.getClass());
        link.setTabIndex(-1);
        return new Tab(link);
    }

}
