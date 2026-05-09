package com.mb.timetracker.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TimeEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    
    @ManyToOne
    private Client client;

    @ManyToOne
    @JoinColumn(name = "matter_id")
    @JsonIgnore
    private Matter matter;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long duration;
	public Long getId() {
		return id;
	}
	public Client getClient() {
	    return client;
	}

	public void setClient(Client client) {
	    this.client = client;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Matter getMatter() {
		return matter;
	}
	public void setMatter(Matter matter) {
		this.matter = matter;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}

}