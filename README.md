# TimeTracker and Billing System API

A Spring Boot-based legal time tracking system designed to automate billable time capture, matter tracking, and invoice generation for legal practices..

## Features

- Client management
- Matter management
- Manual time tracking
- Simulated automated time capture
- Billing and invoice generation
- RESTful API endpoints
- H2 in-memory database integration
- Postman API testing

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Maven
- H2 Database
- Postman
- Git & GitHub

## Project Structure

```text
src/main/java/com/mb/timetracker
│
├── controller
├── service
├── repository
├── model
```

## Example API Endpoints

### Create Client
POST `/clients`

### Create Matter
POST `/matters`

### Start Time Entry
POST `/time/start`

### Stop Time Entry
POST `/time/stop/{id}`

### Generate Invoice
GET `/billing/invoice/{clientId}`

## Objective

The system aims to reduce manual billing inefficiencies within legal practices by automating time tracking and improving billing accuracy.

## Author

Owen Matimba Manyiki
