# Week 2 Progress – Issue #2

## Latest commit

* `2f9c343` – Initial plan (HEAD at 2026-03-10)

---

## Checklist đối chiếu với issue #2

- [ ] Tạo entity ví dụ (Order, Product, User)
  - Đã có: `OrderEntity`, `OrderItem`, `Product`
  - Chưa có: `User` entity
- [x] Tích hợp Spring Data JPA
  - Đã có `spring-boot-starter-data-jpa` và các repository (`ProductRepository`, `OrderRepository`)
- [ ] Demo FetchType và phân tích N+1 problem
  - Có `FetchType.LAZY` ở `OrderItem` và `JOIN FETCH` trong `OrderRepository#findAllWithItems`
  - Chưa có phần mô tả/analysis rõ về N+1 problem
- [x] Thực hành Transaction (@Transactional): demo atomicity, rollback...
  - `OrderService` + `StockService` demo propagation/rollback, có `TransactionTest`
- [x] Thực hiện pagination + sorting (Spring Data)
  - `ProductController` nhận `Pageable`, `ProductService` trả `Page`, `OrderRepository` có query với `Pageable`
- [ ] Viết logging chuẩn (logback, log4j...)
  - Chưa có cấu hình logback/log4j riêng (mới có logging level trong `application.yml`)

---
