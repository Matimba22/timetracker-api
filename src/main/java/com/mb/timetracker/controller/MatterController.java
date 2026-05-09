package com.mb.timetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.mb.timetracker.model.Matter;
import com.mb.timetracker.model.Client;
import com.mb.timetracker.repository.MatterRepository;
import com.mb.timetracker.repository.ClientRepository;

@RestController
@RequestMapping("/matters")
public class MatterController {

	
	@Autowired
    private MatterRepository matterRepo;

    @Autowired
    private ClientRepository clientRepo;

    @PostMapping
    public Matter create(@RequestBody Matter matter) {

        if (matter.getClient() == null || matter.getClient().getId() == null) {
            throw new RuntimeException("Client ID is required");
        }

        Client client = clientRepo.findById(matter.getClient().getId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        matter.setClient(client);

        return matterRepo.save(matter);
     }
    @GetMapping
    public List<Matter> getAll() {
        return matterRepo.findAll();
    }
}