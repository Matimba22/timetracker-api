# MB Legal Time Tracker & Billing System

A full-stack legal time tracking and billing platform built using Spring Boot, designed to help legal practices manage clients, matters, billable hours, invoice generation, and billing analytics through a modern SaaS-style dashboard.

The system automates legal billing workflows by improving time tracking accuracy, invoice management, and financial visibility.

---

# Features

## Legal Matter Management
- Client management
- Matter management
- Matter-based billing workflows

## Time Tracking
- Manual time entry tracking
- Simulated automated time capture
- Billable hours calculation
- Time entry management

## Invoice & Billing System
- Automatic invoice generation
- Professional PDF invoice export
- Invoice status workflow:
  - DRAFT
  - SENT
  - PAID
  - OVERDUE
- Revenue tracking and analytics

## SaaS Dashboard
- KPI statistic cards
- Revenue analytics chart
- Invoice statistics overview
- Responsive enterprise dashboard UI
- Sidebar navigation system

## REST API Integration
- Spring Boot RESTful APIs
- Frontend-backend integration using JavaScript Fetch API
- Real-time dashboard statistics

---

# Technologies Used

## Backend
- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven
- H2 Database
- iText PDF

## Frontend
- HTML5
- CSS3
- JavaScript
- Chart.js

## Tools
- Git & GitHub
- Postman
- Eclipse IDE

---

# Project Structure

```text
src/main/java/com/mb/timetracker
│
├── controller
├── service
├── repository
├── model
├── dto

frontend/
│
├── index.html
├── style.css
├── script.js
├── assets/
│    └── screenshots/

# Dashboard Preview

[Dashboard](assets/screenshots/dashboard.png) 

# Invoice Management

[Invoices](assets/screenshots/invoices.png)

# PDF Invoice

[PDF Invoice](assets/screenshots/pdf-invoice.png)

## Author: Matimba Manyiki
