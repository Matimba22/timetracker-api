package com.mb.timetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.mb.timetracker.model.Client;
import com.mb.timetracker.repository.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientController {

	
	@Autowired
    private ClientRepository repo;

    @PostMapping
    public Client create(@RequestBody Client client) {
        return repo.save(client);
    }

    @GetMapping
    public List<Client> getAll() {
        return repo.findAll();
    }
}