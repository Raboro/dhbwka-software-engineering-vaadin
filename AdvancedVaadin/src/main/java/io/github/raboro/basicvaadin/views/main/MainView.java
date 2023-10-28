package io.github.raboro.basicvaadin.views.main;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import io.github.raboro.basicvaadin.security.SecurityService;
import io.github.raboro.basicvaadin.views.header.HeaderView;
import jakarta.annotation.security.PermitAll;

@PermitAll
@PageTitle("Main")
@Route("")
public class MainView extends AppLayout {

    private final SecurityService securityService;

    public MainView(SecurityService securityService) {
        this.securityService = securityService;
        setPrimarySection(Section.DRAWER);
        addToNavbar(true, new HeaderView(securityService));
    }

}
