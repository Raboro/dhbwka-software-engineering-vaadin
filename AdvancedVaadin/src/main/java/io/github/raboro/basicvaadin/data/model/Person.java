package io.github.raboro.basicvaadin.data.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Marius Wörfel
 */
@Data
@Entity
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;
    private String name;
    private String email;
    private int age;
    private int vacationDays;

    public Person(String name, String email, int age, int vacationDays) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.vacationDays = vacationDays;
    }
}
