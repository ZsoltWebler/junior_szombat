package org.webler.zsolt.SpringTest.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private int age;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Item> items = new ArrayList<>();

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
