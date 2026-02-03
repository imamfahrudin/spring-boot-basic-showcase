# Spring Boot Basic Showcase

[![GitHub](https://img.shields.io/badge/GitHub-Repo-blue)](https://github.com/imamfahrudin/spring-boot-basic-showcase.git)
[![Java](https://img.shields.io/badge/Java-21-orange)](https://openjdk.java.net/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.2-brightgreen)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.9.0-blue)](https://maven.apache.org/)
[![Docker](https://img.shields.io/badge/Docker-Ready-blue)](https://www.docker.com/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

A demo project showcasing fundamental Spring Boot features including REST controllers, JPA entities, transactions, AOP, and configuration.

## Features

- RESTful API for basic user management operations
- JPA entity mapping with H2 in-memory database
- Transaction management with rollback demonstration
- Aspect-Oriented Programming (AOP) for logging
- Spring configuration with custom beans
- OpenAPI/Swagger documentation
- Docker containerization
- Comprehensive API documentation

## Technologies

- **Java 21**
- **Spring Boot 4.0.2**
- **Spring Data JPA** for database operations
- **Spring Web MVC** for REST API
- **Spring AOP** for cross-cutting concerns
- **H2 Database** (in-memory)
- **SpringDoc OpenAPI** for API documentation
- **Lombok** for reducing boilerplate code
- **Maven** for build management
- **Docker** for containerization

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/basic/users` | Get all users |
| `POST` | `/api/basic/save` | Save a new user |
| `POST` | `/api/basic/rollback` | Demonstrate transaction rollback |

## Getting Started

### Prerequisites

- Java 21 or higher
- Maven 3.6+
- Docker (optional, for containerized run)

### Running Locally

1. Clone the repository:
   ```bash
   git clone https://github.com/imamfahrudin/spring-boot-basic-showcase.git
   ```
2. Navigate to the project directory:
   ```bash
   cd spring-boot-basic-showcase
   ```
3. Run with Maven:
   ```bash
   mvn spring-boot:run
   ```
4. Access the application at http://localhost:8080
5. H2 Console: http://localhost:8080/h2-console (JDBC URL: `jdbc:h2:mem:testdb`)
6. Swagger UI: http://localhost:8080/swagger-ui.html

### Running with Docker

1. Build and run with Docker Compose:
   ```bash
   docker-compose up --build
   ```
2. Access the application at http://localhost:8080

### Building

```bash
mvn clean package
```

### Testing

Run the test suite with Maven:

```bash
mvn test
```

## Project Structure

```
spring-boot-basic-showcase/
├── src/
│   ├── main/
│   │   ├── java/com/imamfahrudin/basic/
│   │   │   ├── SpringBootBasicShowcaseApplication.java
│   │   │   ├── config/          # Spring configuration classes
│   │   │   ├── controller/      # REST controllers
│   │   │   ├── entity/          # JPA entity classes
│   │   │   ├── repository/      # JPA repositories
│   │   │   ├── service/         # Business logic services
│   │   │   └── aspect/          # AOP aspects
│   │   └── resources/           # Application configuration
│   └── test/
│       └── java/com/imamfahrudin/basic/
├── docker-compose.yml
├── Dockerfile
├── pom.xml
├── README.md
└── LICENSE
```

## Spring Boot Features Demonstrated

This project demonstrates core Spring Boot concepts:

### REST Controllers
- `@RestController` for building REST APIs
- Request mapping with `@RequestMapping`, `@GetMapping`, `@PostMapping`
- Parameter handling with `@RequestParam`

### JPA and Database
- Entity mapping with `@Entity` and `@Table`
- Repository pattern with `JpaRepository`
- H2 in-memory database configuration

### Dependency Injection
- Constructor-based injection (recommended approach)
- Component scanning with `@Service`, `@Repository`
- Custom bean configuration

### Transaction Management
- Declarative transactions with `@Transactional`
- Rollback behavior demonstration
- Transaction propagation and isolation

### Aspect-Oriented Programming
- Method interception with `@Aspect` and `@Before`
- Pointcut expressions for service layer methods
- Logging cross-cutting concerns

### Configuration
- Application properties configuration
- Custom bean definitions with `@Configuration` and `@Bean`
- Profile-based configuration

## API Examples

### Save User
```bash
POST /api/basic/save?name=john
```

### Demonstrate Transaction Rollback
```bash
POST /api/basic/rollback?name=jane
```

### Get All Users
```bash
GET /api/basic/users
```

## Contributing

### Commit Message Conventions

This project follows conventional commit format. All commit messages must start with `<type>:` where type is one of:

- `feat`: A new feature
- `fix`: A bug fix
- `docs`: Documentation only changes
- `style`: Changes that do not affect the meaning of the code (white-space, formatting, etc.)
- `refactor`: A code change that neither fixes a bug nor adds a feature
- `test`: Adding missing tests or correcting existing tests
- `chore`: Changes to the build process or auxiliary tools

**Examples:**
- `feat: add user validation functionality`
- `fix: resolve transaction rollback issue`
- `docs: update README with API examples`
- `test: add unit tests for user service`

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

Copyright (c) 2026 Mukhammad Imam Fahrudin