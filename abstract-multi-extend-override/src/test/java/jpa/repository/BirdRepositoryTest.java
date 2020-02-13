package jpa.repository;

import jpa.domain.Bird;
import jpa.domain.Hawk;
import jpa.domain.YellowLing;
import jpa.enums.Gender;
import jpa.override.Person;
import jpa.override.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/9 下午1:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BirdRepositoryTest {
    @Autowired
    private BirdRepository birdRepository;

    @Autowired
    private PersonRepository personRepository;

    @Before
    public void setUp() throws Exception {

    }


    @Rollback(false)
    @Test
    public void saveTest() throws Exception {

//        Bird bird = new Bird();
//        bird.setBirdName("b");
//        bird.setName("name");
//        birdRepository.save(bird);

        Hawk hawk = new Hawk();
        hawk.setName("hawk");
        hawk.setHawkName("123");
        hawk.setBirdName("birdName");
        birdRepository.save(hawk);

        YellowLing yellowLing = new YellowLing();
        yellowLing.setName("yellowling");
        yellowLing.setYellowLingName("yellowlong");
        yellowLing.setBirdName("yellowlong");

        // 测试    @Enumerated Enum  转换
        yellowLing.setGender(Gender.female);

        birdRepository.save(yellowLing);

        // Test Override


        Person person = new Person();
        person.setAnimal(hawk);

        personRepository.save(person);


        User user = new User();
        user.setUserName("zhangsan");
        Bird bird = new Bird();

        user.setAnimal(bird);

        personRepository.save(user);

    }


}