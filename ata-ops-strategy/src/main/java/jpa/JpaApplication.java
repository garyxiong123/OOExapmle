package jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Created on 2018/2/5.
 *
 * @author zlf
 * @since 1.0
 */
@EnableJpaAuditing
@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        System.getProperties().setProperty("sprig.application.name","ss");
        ConfigurableApplicationContext context =  SpringApplication.run(JpaApplication.class, args);
        System.out.println("");
    }

}
