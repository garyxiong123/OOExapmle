package jpa.repository;

import jpa.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/9 下午1:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class StudentRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {

    }


    @Rollback(false)
    @Test
    public void saveTest() throws Exception {

        User user = User.builder().email("sss").phone("2233").build();
        Location4America location4America = new Location4America("gary","23","america");
        Address address = Address.builder().city("sdd").location(location4America).build();
        user.setAddress(address);
        user.setHome(Home.builder().homeAddress("ss").homeCity("dsdd").build());
//        user.setCreateTime(LocalDateTime.now());
//        user.setCreateAuthor("sddd");
        userRepository.save(user);
        System.out.println(user);
    }


}