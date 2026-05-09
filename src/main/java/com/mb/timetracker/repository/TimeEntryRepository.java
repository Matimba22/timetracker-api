package com.mb.timetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mb.timetracker.model.TimeEntry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {

    @Query("SELECT t.duration FROM TimeEntry t WHERE t.matter.id = :matterId")
    List<Long> findDurationsByMatterId(@Param("matterId") Long matterId);
}

