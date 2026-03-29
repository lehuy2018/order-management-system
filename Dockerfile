# Dùng Tomcat 10.1 với JDK 21 (hỗ trợ Java 21)
FROM tomcat:10.1-jdk21

# Xoá ứng dụng mặc định (không bắt buộc)
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy file WAR từ thư mục target/ (sẽ được tạo bởi Maven) vào webapps với tên ROOT.war
# => Ứng dụng chạy ngay tại đường dẫn gốc (không cần context path)
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war

# Mở cổng Tomcat
EXPOSE 8080

# Chạy Tomcat
CMD ["catalina.sh", "run"]