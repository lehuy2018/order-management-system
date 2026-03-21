# Week 3 Progress – Issue #4

## Checklist đối chiếu với issue #4

- [x] Thêm dependency security, JWT
  - `spring-boot-starter-security`, `spring-security-web`
  - `jjwt-api`, `jjwt-impl`, `jjwt-jackson` (version 0.12.3)

- [x] Viết login API (JWT)
  - `POST /api/accounts/login` – nhận `username` + `password`, trả về JWT token
  - `POST /api/accounts/register` – đăng ký tài khoản mới, mật khẩu được mã hóa BCrypt
  - `JwtService` xử lý sinh và xác thực token
  - `JwtAuthenticationFilter` kiểm tra JWT trên mỗi request
  - `JwtProperties` đọc cấu hình `secret` và `expiration` từ `application.yml`
  - `JwtAuthenticationEntryPoint` trả về 401 JSON khi chưa xác thực

- [x] Xây dựng role-based authorization
  - `User` entity có thêm field `role` (mặc định `ROLE_USER`)
  - `CustomUserDetailsService` sử dụng role thực tế của user thay vì hardcode
  - `SecurityConfig` cấu hình phân quyền:
    - `/api/accounts/**`, `/swagger-ui/**`, `/v3/api-docs/**` – public
    - `/api/admin/**` – chỉ `ROLE_ADMIN`
    - Còn lại – cần xác thực
  - `@EnableMethodSecurity` bật `@PreAuthorize` cho phân quyền cấp method
  - `TestController`:
    - `GET /api/me` – xem thông tin user hiện tại (cần xác thực)
    - `GET /api/admin/dashboard` – chỉ admin (`@PreAuthorize("hasRole('ADMIN')")`)

- [x] Demo password encoding (BCrypt)
  - `BCryptPasswordEncoder` cấu hình trong `SecurityConfig`
  - Mật khẩu được encode khi đăng ký (`AccountService.register`)
