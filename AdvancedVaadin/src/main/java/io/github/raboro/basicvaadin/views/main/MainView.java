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
        content.addClassName("content-wrraper");
        content.getStyle().set("justify-content", "center");
        content.getStyle().set("padding", "10%");

        Grid<Person> grid = new Grid<>(Person.class, false);
        grid.addColumn(Person::getId).setHeader("Id");
        grid.addColumn(Person::getName).setHeader("Name");
        grid.addColumn(Person::getAge)
                .setHeader("Age")
                .setFooter("Average Age: " + controller.averageAgeOfAllPersons());
        grid.addColumn(Person::getHolidayDays)
                .setHeader("HolidayDays")
                .setFooter("Total Holiday Days: " + controller.countHolidayDaysOfAllPersons());
        grid.setItems(controller.getAllPersons());
        content.add(grid);
        setContent(content);
    }

}
