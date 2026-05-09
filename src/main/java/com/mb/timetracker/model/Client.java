package com.mb.timetracker.model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    private String name;
    private String email;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Matter> matters;

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Matter> getMatters() { return matters; }
    public void setMatters(List<Matter> matters) { this.matters = matters; }
}