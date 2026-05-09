package com.mb.timetracker.service;

import org.springframework.stereotype.Service;
import com.mb.timetracker.repository.TimeEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.mb.timetracker.dto.BillingResponse;
import java.util.List;

@Service
public class BillingService {

@Autowired
private TimeEntryRepository timeRepo;

public BillingResponse getBillingByMatter(Long matterId) {

    List<Long> durations = timeRepo.findDurationsByMatterId(matterId);

    long totalMinutes = durations.stream()
            .mapToLong(Long::longValue)
            .sum();

    double totalHours = totalMinutes / 60.0;

    double hourlyRate = 500.0; 
    double amount = totalHours * hourlyRate;

    return new BillingResponse(
            matterId,
            totalMinutes,
            totalHours,
            amount
    );
}
}