package com.example.pandastock.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_users")
public class User {

    //ID de cada um
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    @Column(name = "username")
    private String username;

    @Column(name = "pin")
    private String pin;

    @CreationTimestamp
    private Instant creationTimeStamp;

    //CONSTRUTOR VAZIO
    public User() {}

    //CONSTRUTOR PARA FUTURAS INSTÂNCIAS
    public User(UUID userId, String username,
                String pin, Instant creationTimeStamp
    ) {

        this.userId = userId;
        this.username = username;
        this.pin = pin;
        this.creationTimeStamp = creationTimeStamp;

    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Instant getCreationTimeStamp() {
        return creationTimeStamp;
    }

    public void setCreationTimeStamp(Instant creationTimeStamp) {
        this.creationTimeStamp = creationTimeStamp;
    }
}

