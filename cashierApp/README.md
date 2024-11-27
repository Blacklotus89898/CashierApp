# CashierApp

CashierApp is a Spring Boot application designed to manage cashier operations. This project uses Gradle for build automation and includes unit tests to ensure the reliability of the application.

## Table of Contents

- [CashierApp](#cashierapp)
  - [Table of Contents](#table-of-contents)
  - [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
  - [Running the Project](#running-the-project)
  - [Testing the Project](#testing-the-project)
  - [Building Docker Image](#building-docker-image)
  - [Running Container](#running-container)

## Getting Started

### Prerequisites

- Java 21
- Gradle
- PostgreSQL

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/CashierApp.git
    cd CashierApp/cashierApp
    ```

2. Configure the database in `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/cashierapp
    spring.datasource.username=postgres
    spring.datasource.password=postgres
    ```

3. Build the project:
    ```sh
    ./gradlew build
    ```

## Running the Project

To build the project, run:
```sh
./gradlew bootrun
```
## Testing the Project

```sh 
./gradlew test
``` 

## Building Docker Image

```sh
docker build -t my-springboot-app .
```

## Running Container

```sh
docker run -p 8080:8080 my-springboot-app
```