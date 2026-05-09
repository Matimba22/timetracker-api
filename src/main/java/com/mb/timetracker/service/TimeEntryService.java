package com.mb.timetracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Duration;
import java.util.List;

import com.mb.timetracker.model.TimeEntry;
import com.mb.timetracker.repository.TimeEntryRepository;

@Service
public class TimeEntryService {

    @Autowired
    private TimeEntryRepository repo;

    public TimeEntry start(TimeEntry entry) {
        entry.setStartTime(LocalDateTime.now());
        return repo.save(entry);
    }

    public TimeEntry stop(Long id) {

        TimeEntry entry = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Time entry not found: " + id));

        if (entry.getStartTime() == null) {
            throw new RuntimeException("Start time missing for ID: " + id);
        }

        if (entry.getEndTime() != null) {
            throw new RuntimeException("Entry already stopped: " + id);
        }
        
        System.out.println("STOP ID: " + id);
        System.out.println("START: " + entry.getStartTime());
        System.out.println("END: " + entry.getEndTime());

        LocalDateTime end = LocalDateTime.now();
        entry.setEndTime(end);

        long minutes = java.time.Duration.between(
                entry.getStartTime(),
                end
        ).toMinutes();

        entry.setDuration(minutes);

        return repo.save(entry);
        
    }
        
        public List<TimeEntry> getAll() {
            return repo.findAll();

    }
}