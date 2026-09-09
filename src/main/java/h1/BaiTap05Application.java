package h1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Diem khoi dong ung dung.
 *
 * Ke thua SpringBootServletInitializer de van deploy duoc thanh file .war len
 * mot Tomcat rieng (ngoai IDE) neu can, nhung khi chay trong STS bang
 * "Run As > Spring Boot App" thi van dung embedded Tomcat binh thuong, khong
 * can cau hinh gi them.
 */
@SpringBootApplication
public class BaiTap05Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BaiTap05Application.class, args);
	}

}
