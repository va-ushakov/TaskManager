package com.example.taskmanager.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Table (name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    Priority priority;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    Status status;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn ()
    private User user;
}
