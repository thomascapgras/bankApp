# Banking Microservices Application

## Description

This is a banking application built using a **microservices architecture** with **Java Spring Boot**. The application provides essential banking features such as account management, transaction processing, and user authentication. It also ensures secure communication between services and fault tolerance using **Kafka** for messaging and **Resilience4j** for resiliency patterns.

## Features

1. **User Management**:
   - Register new users.
   - Manage user profiles (update details, etc.).
   - Secure user authentication using **OAuth2** with **Keycloak**.
   
2. **Account Management**:
   - Create new bank accounts (e.g., savings, checking).
   - View account details such as balance and account history.
   - Link multiple accounts to a single user.

3. **Transaction Processing**:
   - Perform transactions between accounts (deposits, withdrawals, and transfers).
   - Track real-time transactions with Kafka-based communication between microservices.
   - Handle transaction status and confirmations.
   
4. **Resilience and Monitoring**:
   - Implement **Resilience4j** for circuit-breaking and retry mechanisms, ensuring fault tolerance.
   - Centralized logging and tracing using the **ELK stack** (Elasticsearch, Logstash, and Kibana).
   - **Spring Boot Actuator** for monitoring application health and metrics.

5. **Security**:
   - Use **Keycloak** for OAuth2-based authentication and authorization.
   - Protect microservices with **Spring Security** and JWT tokens.
   - Role-based access control for different user levels (e.g., admin, user).

6. **Messaging System**:
   - Inter-service communication is handled through **Apache Kafka**, ensuring asynchronous messaging between services such as account and transaction services.

7. **Database Integration**:
   - Uses **PostgreSQL** as the primary relational database for user and account management.
   - Data persistence and retrieval are managed using **Spring Data JPA** and **Hibernate**.

## Tech Stack

### Backend
- **Java 11**
- **Spring Boot 3**
  - **Spring Data JPA**: For database interactions.
  - **Spring Security**: For securing the microservices.
  - **Spring Cloud**: For building microservices architecture (Eureka for service discovery, Gateway for API gateway).
  - **Resilience4j**: For implementing fault tolerance mechanisms.
  - **Spring Actuator**: For monitoring application health and performance.
- **Keycloak**: For OAuth2 authentication and authorization.
- **Apache Kafka**: For messaging between microservices.
- **PostgreSQL**: For managing user and account data.
- **Hibernate**: For ORM (Object Relational Mapping).

### Frontend
- **Angular 14**: For a responsive frontend interface that communicates with the backend microservices.
- **TypeScript**: Core language for frontend logic.
- **HTML/CSS**: For designing the user interface.

## Architecture Overview

The application follows a **microservices architecture**, with separate services for handling user management, account management, and transaction processing. Each service communicates through **Kafka** for reliable message exchange. Services are secured using **Keycloak** and follow RESTful communication standards.

### Key Services:
1. **User Service**: Manages user registration, authentication, and profile management.
2. **Account Service**: Handles account creation, linking accounts to users, and retrieving account balances.
3. **Transaction Service**: Manages fund transfers between accounts, transaction history, and transaction validation.

### API Gateway:
All microservices are accessible through an API gateway that routes requests to the appropriate service, handles load balancing, and applies security measures.

## Getting Started

### Clone the repository:

```bash
git clone https://github.com/thomascapgras/bankApp.git
cd bankApp
