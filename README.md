# Anatolian Trucking API

REST API backend for the Anatolian Trucking desktop application, built with Spring Boot. This API provides core functionality for managing trucking operations, user authentication, and resource management.

## Features

- RESTful API endpoints for:
  - User management (drivers, managers)
  - Cargo tracking
  - Truck fleet management
  - Destination and checkpoint handling
  - Forum discussions
  - Comment system

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL Database
- Maven

## Getting Started

### Prerequisites

- JDK 17 or higher
- Maven
- MySQL Server

### Installation

1. Clone the repository:
git clone https://github.com/yourusername/anatolian-trucking-api.git

2. Configure database connection in `src/main/resources/application.properties`:
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password

3. Build the project:
mvn clean install

4. Run the application:
mvn spring-boot:run

The API will be available at `http://localhost:8080`

## API Endpoints

### Users
- `GET /allUsers` - Retrieve all users
- `POST /users` - Create a new user
- `PUT /users/{id}` - Update user details
- `DELETE /users/{id}` - Delete a user

Similar endpoints exist for:
- Cargo management
- Truck management
- Destinations
- Checkpoints
- Forums
- Comments

## Current Status

The API currently implements core CRUD operations for all main entities. The basic structure is operational and running on port 8080 locally.

## Future Improvements

- Implementation of complete business logic
- Advanced filtering and search capabilities
- Frontend development
- Authentication and authorization
- API documentation with Swagger
- Deployment configuration
- Integration tests
- Performance optimization

## Contributing

Feel free to fork the repository and submit pull requests.

## License

[MIT](https://choosealicense.com/licenses/mit/)