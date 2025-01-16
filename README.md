# Task Management System - Backend

The **Task Management System - Backend** is built using **Spring Boot**. It serves as the backend for the frontend task management interface, providing REST APIs for task management, authentication, and role-based access control using JWT tokens.

## Features

### Key Features:
- **User Authentication**: Users can log in using email and password, receiving a JWT token for authentication.
- **Task Management**: CRUD operations for tasks, including adding, editing, and deleting tasks.
- **Role-based Access**: Users with different roles (Admin, User) have different levels of access to the API.
- **JWT Authentication**: Secure access to the system using JSON Web Tokens (JWT).
- **API Endpoints**:
  - **Authentication**: `/api/auth/login` to obtain JWT token.
  - **Task Management**: `/api/tasks` for creating, updating, deleting, and listing tasks.

## Technologies Used

### Backend:
- **Spring Boot**: Framework for building Java-based applications and APIs.
- **JWT (JSON Web Token)**: Used for secure authentication without using Spring Security.
- **H2 Database (In-memory)**: Database used for persistence (can be replaced with MySQL in production).
- **JPA/Hibernate**: For ORM (Object Relational Mapping) to interact with the database.

## Prerequisites

To run the backend project, ensure you have the following installed:
- **JDK 11 or higher**
- **Maven** (for building the project)
- **Postman or any API testing tool** for testing the API

## Getting Started

### 1. Clone the Repository:
git clone https://github.com/your-username/task-management-system-backend.git
cd task-management-system-backend
## Steps to Run the Backend

### 2. Install Dependencies:
The dependencies will be handled via Maven, but ensure Maven is installed on your machine.

### 3. Configure application properties:
Modify `src/main/resources/application.properties` to configure the database, JWT secret, and other properties.

### 4. Run the Backend:
```bash
mvn spring-boot:run
