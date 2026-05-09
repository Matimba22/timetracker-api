package com.mb.timetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mb.timetracker.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {}