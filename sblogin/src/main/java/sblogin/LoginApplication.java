package sblogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author cyb
 * @date: 2018/3/30 10:56
 * Description:
 */

@SpringBootApplication
public class LoginApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }
}
