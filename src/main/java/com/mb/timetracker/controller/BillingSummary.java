package com.mb.timetracker.controller;

public class BillingSummary {

    private double totalHours;
    private double rate;
    private double totalAmount;

    public BillingSummary(double totalHours, double rate, double totalAmount) {
        this.totalHours = totalHours;
        this.rate = rate;
        this.totalAmount = totalAmount;
    }

    public double getTotalHours() { return totalHours; }
    public double getRate() { return rate; }
    public double getTotalAmount() { return totalAmount; }
}