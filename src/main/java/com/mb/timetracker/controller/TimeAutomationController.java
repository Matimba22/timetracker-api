package com.mb.timetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import com.mb.timetracker.model.*;
import com.mb.timetracker.repository.*;

@RestController
@RequestMapping("/time")
public class TimeAutomationController {

    @Autowired
    private TimeEntryRepository timeRepo;

    @Autowired
    private ClientRepository clientRepo;

    @Autowired
    private MatterRepository matterRepo;

    @PostMapping("/auto")
    public TimeEntry autoCapture(
            @RequestParam("clientId") Long clientId,
            @RequestParam("matterId") Long matterId,
            @RequestParam("activity") String activity,
            @RequestParam("minutes") int minutes) {

        System.out.println("DEBUG -> clientId: " + clientId);
        System.out.println("DEBUG -> matterId: " + matterId);

        Client client = clientRepo.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client NOT FOUND: " + clientId));

        Matter matter = matterRepo.findById(matterId)
                .orElseThrow(() -> new RuntimeException("Matter NOT FOUND: " + matterId));
        
        if (!matter.getClient().getId().equals(client.getId())) {
            throw new RuntimeException("Matter does not belong to this client");
        }

        TimeEntry entry = new TimeEntry();

        entry.setClient(client);
        entry.setMatter(matter);
        entry.setDescription("AUTO: " + activity);

        entry.setStartTime(LocalDateTime.now().minusMinutes(minutes));
        entry.setEndTime(LocalDateTime.now());

        entry.setDuration((long) minutes);

        entry.setMatter(matter);


        return timeRepo.save(entry);
    }
}