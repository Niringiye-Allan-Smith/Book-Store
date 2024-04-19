# Overview
This repository contains the source code for an advanced bookstore inventory system built using Spring Boot. The primary focus of this project is to provide a robust API for managing books, authors, categories, and orders. The system is designed with modern software construction principles and practices in mind, emphasizing clean code, modularity, SOLID principles, and comprehensive API documentation.

# Features
Book Management: Easily add, update, delete, and retrieve books from the inventory.
Author Management: Manage authors and associate them with books.
Category Management: Organize books into different categories for better navigation.
Order Management: Handle orders placed by customers efficiently.
API Documentation: Detailed documentation for all API endpoints to facilitate integration and usage.
## Technologies Used
Spring Boot: Provides a robust framework for building Java-based applications with ease.
Spring Data JPA: Simplifies data access by providing a repository abstraction over JPA.
Spring Web: Enables building web applications, including RESTful services.
Swagger UI: Automatically generates interactive API documentation for easy exploration.
MySQL: Used as the database to store book, author, category, and order information.
# Getting Started
## To get started with the project, follow these steps:
Clone the repository:
bash
## Copy code
git clone (https://github.com/Niringiye-Allan-Smith/Book-Store)-api.git
## Configure the Database:
Install MySQL if not already installed.
Create a new database named bookstore.
Update the database configurations in application.properties if necessary.
## Build and Run the Application:
cd bookstore-api
./mvnw spring-boot:run
Explore the API Documentation:Once the application is running, navigate to http://localhost:8080/swagger-ui.html in your web browser to explore the API endpoints and interact with them using Swagger UI.
# Contributing
Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or submit a pull request.
