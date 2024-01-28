# Basic Structure
> Full Stack Web Application containing both backend and frontend part basic structure with spring framework as backend and any frontend framework(react, angular) as frontend.


    your-project-name/
    |-- backend/
    |   |-- src/
    |   |   |-- main/
    |   |   |   |-- java/
    |   |   |   |   |-- com/
    |   |   |   |   |   |-- yourcompany/
    |   |   |   |   |   |   |-- Application.java (Spring Boot main class)
    |   |   |   |   |   |   |-- controller/
    |   |   |   |   |   |   |   |-- ApiController.java (REST API controllers)
    |   |   |   |   |   |   |-- model/
    |   |   |   |   |   |   |   |-- YourEntity.java (Hibernate entity)
    |   |   |   |   |   |   |-- repository/
    |   |   |   |   |   |   |   |-- YourRepository.java (Data access repository)
    |   |   |   |   |   |   |-- service/
    |   |   |   |   |   |   |   |-- YourService.java (Business logic)
    |   |   |-- resources/
    |   |       |-- application.properties (Database and Spring configuration)
    |
    |-- frontend/
    |   |-- public/
    |   |   |-- index.html
    |   |-- src/
    |   |   |-- components/
    |   |   |   |-- YourComponent.js
    |   |   |-- App.js
    |   |   |-- index.js
    |   |   |-- serviceWorker.js
    |   |-- package.json
    |   |-- .babelrc
    |
    |-- docker-compose.yml (for Docker-based deployment)
    |-- README.md