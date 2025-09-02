# Bean Validation and Exception Handling Demo

This is a **Spring Boot application** demonstrating:
- API input validation using **Jakarta Bean Validation (JSR 380)**  
- Global exception handling using **`@ControllerAdvice`** and **`@ExceptionHandler`**  
- In-memory **H2 database** integration  

---

## Features
- User creation with validation rules:
  - `userName` must not be blank  
  - `email` must be a valid email format  
  - `age` must be greater than 0  
  - `gender` must be `M` or `F`  
- Prevents duplicate user registration (email must be unique).  
- Centralized error responses in JSON format.  

---

## Tech Stack
- Java 17+  
- Spring Boot 3.x  
- Spring Data JPA  
- H2 Database (in-memory)  
- Jakarta Bean Validation (Hibernate Validator)  

---

## Project Structure
"# springBootValidation_exceptionHandling" 

