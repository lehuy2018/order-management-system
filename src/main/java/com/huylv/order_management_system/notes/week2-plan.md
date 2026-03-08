# Week 2 Plan – Advanced JPA and API Design

## Goals

Trong tuần 2 mình muốn tập trung vào:

* Hiểu sâu Spring Data JPA
* Quan hệ giữa các entity
* Transaction management
* Pagination và filtering
* DTO mapping

---

# Day 1 – Entity Relationships

Học các loại quan hệ trong JPA:

```
@OneToMany
@ManyToOne
@OneToOne
@ManyToMany
```

Ví dụ:

Order → OrderItems

---

# Day 2 – DTO Mapping

Tìm hiểu cách map giữa Entity và DTO.

Các cách mapping:

* Manual mapping
* Mapper class
* MapStruct

---

# Day 3 – Transactions

Hiểu về transaction trong Spring.

Annotation:

```
@Transactional
```

Các concept:

* propagation
* rollback
* isolation level

---

# Day 4 – Pagination & Sorting

Sử dụng Spring Data JPA pagination.

Classes:

```
Page
Pageable
Sort
```

API ví dụ:

```
GET /products?page=0&size=10
```

---

# Day 5 – Search API

Implement search API.

Ví dụ:

```
GET /products?name=iphone
```

Sử dụng:

* Query methods
* Specification
* Custom queries

---

# Expected Outcome

Sau tuần 2, project sẽ có thêm:

* Entity relationships
* Pagination API
* Search API
* Transaction management
* DTO mapping chuẩn hơn

---