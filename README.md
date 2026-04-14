# Order Management System (Spring Boot)

## Overview

A backend REST API system for managing users and orders, designed with real-world backend practices in mind.

This project demonstrates my ability to build secure, scalable, and maintainable backend services using Spring Boot, including authentication, authorization, caching, and deployment.

---

## Tech Stack

* Java 17
* Spring Boot
* Spring Security (JWT Authentication)
* Spring Data JPA
* MySQL / PostgreSQL
* Redis (Caching)
* Docker
* GitHub Actions (CI/CD)

---

## Features

* JWT-based authentication (login/register)
* Role-based access control (RBAC)
* Order management (CRUD operations)
* Pagination and sorting
* Global exception handling
* Redis caching for performance optimization
* Clean layered architecture (Controller → Service → Repository)

---

## API Endpoints

### Authentication

* `POST /api/auth/register`
* `POST /api/auth/login`

### Users

* `GET /api/users`
* `GET /api/users/{id}`

### Orders

* `POST /api/orders`
* `GET /api/orders`
* `PUT /api/orders/{id}`
* `DELETE /api/orders/{id}`

---

## Sample Request

### Login

**POST** `/api/auth/login`

```json
{
  "username": "admin",
  "password": "123456"
}
```

---

## How to Run

### 1. Clone the repository

```bash
git clone https://github.com/lehuy2018/order-management-system.git
cd order-management-system
```

### 2. Run with Docker

```bash
docker-compose up --build
```

### 3. Access the application

```
http://localhost:8080
```

---

## Architecture

This project follows a standard layered architecture:

* **Controller**: Handles HTTP requests
* **Service**: Contains business logic
* **Repository**: Handles data access

Additional design practices:

* DTO pattern for data transfer
* Centralized exception handling
* Separation of concerns for maintainability

---

## Highlights

* Designed RESTful APIs following best practices
* Implemented secure authentication using JWT and Spring Security
* Applied role-based access control for data protection
* Optimized database queries using JOINs and indexing
* Integrated Redis caching to improve performance
* Containerized application using Docker
* Automated build and deployment with GitHub Actions

---

## Deployment

* Dockerized application for consistent environments
* CI/CD pipeline configured using GitHub Actions

---

## Future Improvements

* Microservices architecture
* API Gateway integration
* Distributed caching
* Advanced monitoring and logging

---

## Author

Le Van Huy
Java Backend Developer

GitHub: https://github.com/lehuy2018/order-management-system