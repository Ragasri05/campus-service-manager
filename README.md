# Campus Service Management System

A full-stack web application for managing campus service requests such as IT issues, hostel complaints, maintenance requests, library issues, and academic support requests.

## Features

- Create campus service requests
- View all service requests
- Track request priority
- Track request status
- Mark requests as resolved
- Delete service requests
- Persistent data storage using PostgreSQL
- RESTful APIs using Spring Boot
- Interactive web frontend
- Frontend-backend integration using JavaScript Fetch API
- Layered backend architecture using Controller, Service, and Repository layers

## Tech Stack

### Backend

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate

### Database

- PostgreSQL
- SQL

### Frontend

- HTML5
- CSS3
- JavaScript
- Fetch API

### Tools

- IntelliJ IDEA
- Maven
- Git
- GitHub

## System Architecture

```text
                  User
                   |
                   v
          HTML / CSS / JavaScript
                   |
                   | HTTP / REST
                   v
        ServiceRequestController
                   |
                   v
         ServiceRequestService
                   |
                   v
       ServiceRequestRepository
                   |
                   v
             JPA / Hibernate
                   |
                   v
              PostgreSQL
```
## Project Structure
```
campus-service-manager/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── Campu/
│       │       └── Service/
│       │           └── Manager/
│       │               ├── controller/
│       │               │   └── ServiceRequestController.java
│       │               │
│       │               ├── service/
│       │               │   └── ServiceRequestService.java
│       │               │
│       │               ├── repository/
│       │               │   └── ServiceRequestRepository.java
│       │               │
│       │               └── model/
│       │                   └── ServiceRequest.java
│       │
│       └── resources/
│           ├── static/
│           │   ├── index.html
│           │   ├── style.css
│           │   └── script.js
│           │
│           └── application.properties
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## Core Functionality
### Create Request

Users can submit a service request with:

- Title
- Description
- Category
- Priority

The backend automatically assigns:

- Unique request ID
- OPEN status
- Creation timestamp
- View Requests

All service requests are retrieved from PostgreSQL through the REST API and displayed dynamically on the frontend.

### Update Request

Requests can be updated through the REST API, including changing their status.

The frontend provides a Mark Resolved action that changes the request status from:

OPEN → RESOLVED

### Delete Request
Users can delete service requests directly from the frontend.

## Rest API
| Method | Endpoint             | Description                   |
| ------ | -------------------- | ----------------------------- |
| POST   | `/api/requests`      | Create a service request      |
| GET    | `/api/requests`      | Retrieve all service requests |
| GET    | `/api/requests/{id}` | Retrieve a request by ID      |
| PUT    | `/api/requests/{id}` | Update a service request      |
| DELETE | `/api/requests/{id}` | Delete a service request      |

### Example API request
```
{
  "title": "Hostel Wi-Fi not working",
  "description": "Wi-Fi connection is unavailable in the hostel.",
  "category": "IT",
  "priority": "HIGH"
}
```

## Database

The application uses PostgreSQL for persistent data storage.

Create the database using:

```CREATE DATABASE campus_db;```

Configure the database connection in:

`src/main/resources/application.properties`

Example configuration:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/campus_db
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8081
```
> Replace YOUR_PASSWORD with your local PostgreSQL password.

## Running the Application

### 1. Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/campus-service-manager.git
```

### 2. Open the Project

Open the cloned project in **IntelliJ IDEA**.

### 3. Configure PostgreSQL

Create the `campus_db` database in PostgreSQL.

Configure your PostgreSQL username and password in:

```text
src/main/resources/application.properties
```

### Example:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/campus_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

### 4. Run the Application

Run the following Spring Boot application from IntelliJ IDEA:

```text
CampusServiceManagerApplication
```

The backend starts on:

```text
http://localhost:8081
```

### 5. Open the Application

Visit:

```text
http://localhost:8081/
```

## API Testing

The REST API can be tested using:

- IntelliJ HTTP Client
- Postman
- PowerShell
- Browser for `GET` requests

### Example API Request

### Get All Service Requests

```http
GET http://localhost:8081/api/requests
```

Or open the following URL in a browser:

```text
http://localhost:8081/api/requests
```

## Architecture

The backend follows a layered architecture.

### Controller Layer

Handles HTTP requests and exposes REST endpoints.

#### `ServiceRequestController`

Responsible for handling incoming HTTP requests and routing them to the appropriate service methods.

### Service Layer

Contains the application and business logic.

#### `ServiceRequestService`

Responsible for processing service requests and implementing the application's business logic.

### Repository Layer

Handles database operations using Spring Data JPA.

#### `ServiceRequestRepository`

Responsible for interacting with the database and performing CRUD operations.

### Model Layer

Defines the database entity.

#### `ServiceRequest`

Represents a service request stored in the database.

## Key Concepts Demonstrated

- Object-Oriented Programming
- REST API Development
- CRUD Operations
- Spring Boot
- Dependency Injection
- Spring Data JPA
- Hibernate ORM
- PostgreSQL
- Relational Database Integration
- HTTP Methods
- JSON Request/Response Handling
- Frontend-Backend Integration
- Layered Architecture
- Git Version Control

## Future Improvements

- User Authentication
- Role-Based Access Control
- Admin Dashboard
- Request Assignment to Campus Staff
- Search and Filtering
- Pagination and Sorting
- Email Notifications
- Request History and Audit Logs
- Automated Unit Testing
- Integration Testing
- Angular Frontend
- Docker Deployment
- Cloud Deployment

## Author

**Adapa Raga Sridatta**
**Computer Science and Engineering**
**Amrita Vishwa Vidyapeetham, Amritapuri**
