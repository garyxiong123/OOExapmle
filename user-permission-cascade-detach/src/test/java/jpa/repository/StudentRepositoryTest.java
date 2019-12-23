package jpa.repository;

import jpa.domain.Address;
import jpa.domain.Home;
import jpa.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
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

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private EntityManager entityManager;

    @Before
    public void setUp() throws Exception {

    }


    @Test
    public void saveNoId() throws Exception {

        User user = User.builder().username("zhangsan").build();
        Address address = Address.builder().city("china").build();

        entityManager.getProperties();
        user.setAddress(address);
        userRepository.save(user);



        System.out.println(user);
    }

    @Test
    public void saveAddressWithInvalidId() throws Exception {

        User user = User.builder().username("zhangsan").build();
        Address address = Address.builder().city("china").build();
        address.setId(1L);
        user.setAddress(address);
        userRepository.save(user);



        System.out.println(user);
    }

    @Test
    public void saveAddressWithValidId() throws Exception {

        Address address = Address.builder().city("china").build();

        addressRepository.save(address);
        User user = User.builder().username("zhangsan").build();
        user.setAddress(address);

        userRepository.save(user);



        System.out.println(user);
    }

    @Test
    public void saveAllWithId() throws Exception {

        Address address = Address.builder().city("china").build();
        address.setId(1L);

        addressRepository.save(address);

        User user = User.builder().username("zhangsan").build();
        user.setId(5L);

        user.setAddress(address);

        userRepository.save(user);



        System.out.println(user);
    }

    @Test
    public void saveUserWithId() throws Exception {

        User user = User.builder().username("zhangsan").build();
        Address address = Address.builder().city("china").build();

        entityManager.getProperties();
        user.setAddress(address);
        userRepository.save(user);

        User user2 = User.builder().username("zhangsan").build();
        user2.setAddress(address);
        userRepository.save(user);


        System.out.println(user);
    }




}