package com.lotre.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;
@Entity
@Table(name = "User")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Project> projects;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks;
}
