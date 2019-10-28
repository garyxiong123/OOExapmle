package cn.merryyou.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Created on 2018/2/5.
 *
 * @author zlf
 * @since 1.0
 */
//@EntityScan(basePackages={"cn.***.***.domain"})
@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

}
