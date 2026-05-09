package com.mb.timetracker.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import com.mb.timetracker.model.*;

@Service
public class InvoiceService {

    public Invoice generateInvoice(Matter matter, double hourlyRate) {

        List<TimeEntry> entries = matter.getTimeEntries();

        // Calculate total hours
        double totalHours = entries.stream()
                .mapToDouble(entry -> {
                    if (entry.getDuration() == null) return 0;
                    return entry.getDuration() / 60.0; // assuming duration is in minutes
                })
                .sum();

        //  Create invoice
        Invoice invoice = new Invoice();
        invoice.setInvoiceNumber("INV-" + System.currentTimeMillis());
        invoice.setCreatedAt(LocalDateTime.now());
        invoice.setHourlyRate(hourlyRate);
        invoice.setTotalHours(totalHours);
        invoice.setTotalAmount(totalHours * hourlyRate);
        invoice.setStatus(InvoiceStatus.DRAFT);

        //  Relationships
        invoice.setMatter(matter);
        invoice.setClient(matter.getClient());
        invoice.setTimeEntries(entries);

        return invoice;
    }
}