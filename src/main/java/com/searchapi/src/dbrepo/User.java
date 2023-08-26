package com.searchapi.src.dbrepo;


import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    String name;

    @Column(name = "completed")
    private boolean completed;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "createdTime")
    public LocalTime createdTime;

    public User(){};

    public User(String name, boolean completed){
        this.name = name;
        this.completed = completed;
    };

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @PrePersist
    public void prePersist() {
        createdTime = LocalTime.now();
    }
}
