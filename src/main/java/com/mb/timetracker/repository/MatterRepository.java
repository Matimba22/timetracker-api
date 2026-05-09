package com.mb.timetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mb.timetracker.model.Matter;

public interface MatterRepository extends JpaRepository<Matter, Long> {}