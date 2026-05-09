package com.mb.timetracker.controller;

import com.mb.timetracker.dto.BillingResponse;
import com.mb.timetracker.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @GetMapping("/matter/{id}")
    public BillingResponse getBilling(@PathVariable("id") Long matterId) {
        return billingService.getBillingByMatter(matterId);
    }
}