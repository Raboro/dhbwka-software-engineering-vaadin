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
    private String age;
    private int holidayDays;

    public Person(String name, String email, String age, int holidayDays) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.holidayDays = holidayDays;
    }
}
