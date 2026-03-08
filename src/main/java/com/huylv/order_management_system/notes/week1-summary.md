# Week 1 Summary – Spring Boot Fundamentals

## Overview

Trong tuần 1, mình tập trung xây dựng nền tảng backend với Spring Boot, bao gồm REST API, JPA, validation và exception handling.

Project: **Order Management System**

---

# 1. Spring Boot Basics

Spring Boot giúp xây dựng ứng dụng Spring nhanh hơn bằng cách:

* Auto configuration
* Embedded server (Tomcat)
* Starter dependencies

Annotation quan trọng:

```java
@SpringBootApplication
```

---

# 2. REST API Development

Các annotation sử dụng:

```java
@RestController
@RequestMapping
@GetMapping
@PostMapping
@PutMapping
@DeleteMapping
```

Ví dụ API:

```
GET /products
POST /products
GET /orders
POST /orders
```

---

# 3. Spring Data JPA

Sử dụng JPA để làm việc với database.

Ví dụ Entity:

```java
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
}
```

Repository:

```java
public interface ProductRepository extends JpaRepository<Product, Long> {
}
```

Lợi ích:

* CRUD tự động
* Pagination
* Query method

---

# 4. Service Layer

Service layer chứa business logic.

Flow của application:

```
Controller → Service → Repository → Database
```

---

# 5. Validation

Sử dụng validation annotations:

```java
@NotNull
@NotBlank
@Size
@Valid
```

Ví dụ:

```java
public class ProductRequest {

    @NotBlank
    private String name;

    @NotNull
    private Double price;
}
```

---

# 6. Global Exception Handling

Sử dụng:

```java
@ControllerAdvice
@ExceptionHandler
```

Giúp xử lý lỗi tập trung thay vì viết try/catch trong controller.

---

# 7. Bean Lifecycle

Spring bean lifecycle gồm:

```
1. Bean instantiated
2. Dependency injection
3. @PostConstruct
4. Bean ready
5. @PreDestroy
```

---

# 8. Project Structure

Project sử dụng layered architecture:

```
controller
service
repository
entity
dto
exception
config
```

---

# Kết luận

Sau tuần 1, mình đã có thể:

* Tạo REST API với Spring Boot
* Sử dụng Spring Data JPA
* Xây dựng CRUD API
* Áp dụng validation
* Xử lý exception toàn cục
* Hiểu bean lifecycle
* Hiểu project structure

---