package io.github.raboro.basicvaadin.views.login;

import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * @author Marius Wörfel
 */
@Route("login")
@PageTitle("Login")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    private final LoginForm loginForm = new LoginForm();

    public LoginView() {
        this.addClassName("login-view");
        this.setSizeFull();
        this.setAlignItems(Alignment.CENTER);
        this.setJustifyContentMode(JustifyContentMode.CENTER);
        loginForm.setAction("login");
        this.add(loginForm);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if (containsError(beforeEnterEvent)) {
            loginForm.setError(true);
        }
    }

    private boolean containsError(BeforeEnterEvent beforeEnterEvent) {
        return beforeEnterEvent.getLocation().getQueryParameters().getParameters().containsKey("error");
    }
}
