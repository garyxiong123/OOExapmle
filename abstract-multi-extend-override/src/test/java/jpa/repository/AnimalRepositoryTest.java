package jpa.repository;

import jpa.domain.Animal;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/8 下午1:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AnimalRepositoryTest {

    @Autowired
    private AnimalRepository animalRepository;

    @Rollback(false)
    @Test
    public void saveTest() throws Exception {
//        Animal animal = Animal.builder().name("1222").build();

    }

}