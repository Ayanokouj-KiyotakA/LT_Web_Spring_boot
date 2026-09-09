# Bai tap 05 - CRUD admin (Category, User) bang Spring Boot 4

CRUD cho bang `categories` va `app_user` (dung lai DB `QLJPA` cua bai_tap_02),
co chuc nang tim kiem, dung Spring Boot 4 + Spring MVC + Spring Data JPA +
JSP/JSTL.

## 1. Import vao Spring Tool Suite (STS)

1. Mo STS.
2. `File > Import... > Maven > Existing Maven Projects`.
3. Chon thu muc goc project nay (`LT_Web_spring_boot`) roi Finish.
4. STS se tu doc `pom.xml` va tai dependency (lan dau can internet, cho 1-2
   phut). Neu thay loi do Eclipse chua nhan Java 21 -> vao
   `Window > Preferences > Java > Installed JREs`, them JDK 17/21 neu chua co.
5. Chuot phai vao project > `Maven > Update Project...` (Alt+F5) neu can force
   Eclipse doc lai pom sau khi sua.

## 2. Chay ung dung

Cach 1 - trong STS: chuot phai vao `BaiTap05Application.java` (trong
`src/main/java/h1`) > `Run As > Spring Boot App` (hoac `Java Application`).

Cach 2 - dong lenh (khong can mo STS):
```bash
mvn spring-boot:run
```

Sau khi thay dong log `Started BaiTap05Application`, mo trinh duyet:
- http://localhost:8080/admin/categories
- http://localhost:8080/admin/users

Da test thuc te ca 2 trang: xem danh sach, tim kiem, them, sua, xoa - hoat
dong dung tren DB SQL Server that (`QLJPA`).

## 3. Yeu cau moi truong

- JDK 17+ (Spring Boot 4 yeu cau toi thieu Java 17). May dang cai JDK 26 -
  van bien dich va chay duoc binh thuong (pom.xml gioi han `<java.version>21</java.version>`
  de bytecode tuong thich rong hon).
- SQL Server dang chay o `localhost:1433`, database `QLJPA` (giong bai_tap_02).
  Sua lai `src/main/resources/application.properties` neu ban dung
  database/username/password khac.
