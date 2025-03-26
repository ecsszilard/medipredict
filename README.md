# Medipredict Backend

This is a backend application for managing clients and medical data for Medipredict.

## 🛠️ Tech Stack
- **Java 21**
- **Spring Boot 3.4.4**
- **PostgreSQL**
- **Docker & Docker Compose**
- **Swagger API Documentation**

---

## 🚀 How to Run Locally

### 1️⃣ Clone the repository
```sh
git clone https://github.com/YOUR_GITHUB_USERNAME/medipredict.git
cd medipredict
```

### 2️⃣ Start PostgreSQL in Docker
Before building the services, ensure that PostgreSQL is running in Docker:
```sh
docker-compose up -d postgres
```

### 3️⃣ Build the Java microservices
Run the following command to build the Spring Boot applications:
```sh
mvn clean install -DskipTests
```

### 4️⃣ Start the full system in Docker
Now you can start all services (client-service, medical-service, and PostgreSQL) using:
```sh
docker-compose up --build
```

### 5️⃣ API Documentation (Swagger)
Once the services are running, the API documentation can be accessed at:
- **Client Service**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **Medical Service**: [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)

### 6️⃣ Stop the system
To stop the running containers, use:
```sh
docker-compose down
```

---

## 📂 Project Structure
```
medipredict-backend/
│── client-service/         # Microservice for client data (CRUD)
│── medical-service/        # Microservice for medical data (CRUD, pagination)
│── docker-compose.yml      # Docker config to run the entire system
│── README.md               # Documentation
│── .gitignore              # Ignore unnecessary files
```

---

## ✅ Features Implemented
- CRUD operations for clients and medical data.
- Swagger documentation for API endpoints.
- PostgreSQL database integration.
- Dockerized microservices with a single `docker-compose up` command.
- Daily logging of client count at 8 AM.

---

## 🔥 Future Improvements
- Implement RabbitMQ for email notifications.
- Add support for large file uploads.
- Improve security with authentication & authorization.
