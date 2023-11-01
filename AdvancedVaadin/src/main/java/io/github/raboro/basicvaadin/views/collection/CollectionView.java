package io.github.raboro.basicvaadin.views.collection;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

/**
 * @author MariusWoerfel
 */
@PermitAll
@PageTitle("Collection")
@Route("/collection")
public class CollectionView extends AppLayout {

    public CollectionView() {

    }
}