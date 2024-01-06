package com.lotre.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Task")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Task {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    private String name;
    private String description;
    private String priority;
    private String state;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;


}

