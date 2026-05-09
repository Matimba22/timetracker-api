package com.mb.timetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import com.mb.timetracker.model.*;
import com.mb.timetracker.repository.*;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceRepository invoiceRepo;

    @Autowired
    private ClientRepository clientRepo;

    @Autowired
    private TimeEntryRepository timeRepo;

    @PostMapping("/{clientId}")
    public Invoice generate(@PathVariable Long clientId) {

        Client client = clientRepo.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        List<TimeEntry> entries = timeRepo.findAll();

        Invoice invoice = new Invoice();

        invoice.setInvoiceNumber("INV-" + System.currentTimeMillis());
        invoice.setClient(client);
        invoice.setCreatedAt(LocalDateTime.now());
        invoice.setTimeEntries(entries);

        double rate = 2.0;

        double totalHours = entries.stream()
                .mapToDouble(e -> e.getDuration() == null ? 0 : e.getDuration() / 60.0)
                .sum();

        invoice.setHourlyRate(rate);
        invoice.setTotalHours(totalHours);
        invoice.setTotalAmount(totalHours * rate);
        invoice.setStatus(InvoiceStatus.DRAFT);
        
        return invoiceRepo.save(invoice);
    }
    
    @GetMapping("/{id}")
    public Invoice getById(@PathVariable Long id) {
        return invoiceRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
    }

    @GetMapping
    public List<Invoice> getAll() {
        return invoiceRepo.findAll();
    }
}



