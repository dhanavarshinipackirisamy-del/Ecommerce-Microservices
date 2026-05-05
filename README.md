# 📚 Bookstore Microservices

A simple e-commerce backend for a bookstore built using **Spring Boot 3.x, Spring Cloud, and Java 17**.

---

## 🏗️ Architecture

* Microservices-based system
* Each service has its own database
* API Gateway handles all requests
* Services communicate using Feign (REST) and Kafka

---

## 🔧 Core Services

* API Gateway (Port 8080) → Routing, JWT validation
* Eureka Server (Port 8761) → Service discovery
* Config Server (Port 8888) → Central config

---

## 📦 Microservices

* User Service (8081) → Login, Register, JWT
* Product Service (8083) → Book CRUD
* Order Service (8087) → Place orders
* Cart Service (8084) → Cart handling
* Wishlist Service (8085) → Wishlist
* Customer Service (8086) → Address
* Feedback Service (8088) → Reviews
* Notification Service (8089) → Email/SMS

---

## 🔐 Security

* JWT Authentication
* Token generated in User Service
* Validated in API Gateway

---

## 🛠️ Tech Stack

* Java 17
* Spring Boot 3.x
* Spring Cloud
* Eureka
* Gateway
* Feign Client
* Kafka
* PostgreSQL
* Redis
* Maven

---

## 🚀 How to Run

1. Start Eureka Server
2. Start Config Server
3. Start all microservices
4. Start API Gateway

---

## 🧪 Example Flow

User Login → Get Token
↓
Call API via Gateway
↓
Order Service → Product Service → User Service
↓
Order Created

---

## 📌 Features

* Microservices architecture
* Independent databases
* API Gateway routing
* JWT security
* Inter-service communication

---

## 👨‍💻 Project

Spring Boot Microservices Project (Production-style)
