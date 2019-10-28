package jpa;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/24 上午10:57
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PromotionServiceTest {

    @Before
    public void before() {
        System.getProperties().setProperty("spring.application.name", "ss");
    }


    @Test
    public void calculate() {
    }
}