package io.github.raboro.basicvaadin.data.repository;

import io.github.raboro.basicvaadin.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Marius Wörfel
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
