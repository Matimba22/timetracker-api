package com.mb.timetracker.model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Matter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;   
    
    private Double hourlyRate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;   

    @OneToMany(mappedBy = "matter")
    @JsonIgnore
    private List<TimeEntry> timeEntries;

    public Long getId() {
        return id;
    }

    public String getName() {   
        return name;
    }

    public void setName(String name) {   
        this.name = name;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<TimeEntry> getTimeEntries() {
        return timeEntries;
    }

    public void setTimeEntries(List<TimeEntry> timeEntries) {
        this.timeEntries = timeEntries;
    }
}