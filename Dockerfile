# Sử dụng JDK 21 chính thức (ổn định, production-ready)
FROM eclipse-temurin:21-jdk-jammy

# Tạo thư mục làm việc trong container
WORKDIR /app

# Copy file JAR từ máy host vào container
# Dùng wildcard để tránh lỗi sai tên file
COPY target/*.jar app.jar

# Expose port (mang tính document, không bắt buộc)
EXPOSE 8080

# Lệnh chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]