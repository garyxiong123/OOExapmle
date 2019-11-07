package jpa;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created on 2018/2/5.
 *
 * @author zlf
 * @since 1.0
 */
@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(JpaApplication.class, args);
        System.out.println(run);
    }

}
