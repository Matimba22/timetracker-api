package com.mb.timetracker.dto;

public class BillingResponse {

    private Long matterId;
    private Long totalMinutes;
    private double totalHours;
    private double amount;

    public BillingResponse(Long matterId, Long totalMinutes, double totalHours, double amount) {
        this.matterId = matterId;
        this.totalMinutes = totalMinutes;
        this.totalHours = totalHours;
        this.amount = amount;
    }

    public Long getMatterId() {
        return matterId;
    }

    public Long getTotalMinutes() {
        return totalMinutes;
    }

    public double getTotalHours() {
        return totalHours;
    }

    public double getAmount() {
        return amount;
    }
}