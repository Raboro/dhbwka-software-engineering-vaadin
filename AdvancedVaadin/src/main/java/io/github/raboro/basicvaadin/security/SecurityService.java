package io.github.raboro.basicvaadin.security;

import com.vaadin.flow.spring.security.AuthenticationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Marius Wörfel
 */
@Component
public class SecurityService {

    private final AuthenticationContext authenticationContext;

    public SecurityService(AuthenticationContext authenticationContext) {
        this.authenticationContext = authenticationContext;
    }

    public UserDetails getAuthenticatedUser() {
        Optional<UserDetails> authenticatedUser = authenticationContext.getAuthenticatedUser(UserDetails.class);
        return authenticatedUser.orElse(null);
    }

    public void logout() {
        authenticationContext.logout();
    }
}