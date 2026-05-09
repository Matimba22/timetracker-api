package com.mb.timetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mb.timetracker.model.Matter;
import com.mb.timetracker.model.TimeEntry;
import com.mb.timetracker.repository.MatterRepository;
import com.mb.timetracker.service.TimeEntryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/time")
public class TimeEntryController {

    @Autowired
    private MatterRepository matterRepo;

    @Autowired
    private TimeEntryService service;

    @PostMapping("/start")
    public TimeEntry start(@RequestParam("matterId") Long matterId,
            @RequestBody TimeEntry entry) {


        Matter matter = matterRepo.findById(matterId)
                .orElseThrow(() -> new RuntimeException("Matter not found"));

        entry.setMatter(matter);
        entry.setClient(matter.getClient());

        return service.start(entry);
    }

    @PostMapping("/stop/{id}")
    public TimeEntry stop(@PathVariable ("id") Long id) {
        return service.stop(id);
    }

    @GetMapping
    public List<TimeEntry> getAll() {
        return service.getAll();
    }
}