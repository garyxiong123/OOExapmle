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
    public void saveAWithId() throws Exception {

        User user = User.builder().username("zhangsan").build();
        user.setId(8L);
        userRepository.save(user);


        System.out.println(user);
    }

    @Rollback(false)
    @Test
    public void saveAWithIdClearManager() throws Exception {

        User user = User.builder().username("zhangsan11").build();
        user.setId(1L);
        userRepository.save(user);

//        entityManager.clear();

//        userRepository.save(user);

        System.out.println(user);
    }


    @Rollback(false)
    @Test
    public void saveAWithIdManualInsert() throws Exception {

        User user = User.builder().username("zhangsan888").build();
        user.setId(190L);
        userRepository.save(user);

//        entityManager.clear();

//        userRepository.save(user);

        System.out.println(user);
    }


    @Test
    public void saveNoId() throws Exception {

        User user = User.builder().username("zhangsan").build();
        Address address = Address.builder().city("china").build();

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
    public void saveAddressWithValidIdByFind() throws Exception {

        Address address = createAndSaveAddress();
//        entityManager.clear();

        Address address1 = addressRepository.findOne(address.getId());

        User user = User.builder().username("zhangsan").build();

        user.setAddress(address1);

        userRepository.save(user);


        System.out.println(user);
    }

    @Test
    public void saveAddressWithValidIdBySave() throws Exception {

        Address address = createAndSaveAddress();

        User user = User.builder().username("zhangsan").build();

        user.setAddress(address);

        userRepository.save(user);


        System.out.println(user);
    }

    @Test
    public void saveAddressWithValidIdByManualInsertAndFind() throws Exception {

        Address address = addressRepository.findOne(1L);

        User user = User.builder().username("zhangsan").build();
        user.setAddress(address);

        userRepository.save(user);


        System.out.println(user);
    }

    private Address createAndSaveAddress() {
        Address address = Address.builder().city("china").build();
        addressRepository.save(address);
        return address;
    }

    @Test
    public void saveAddressWithValidIdAndInvalidIt() throws Exception {

        Address address = createAndSaveAddress();
        entityManager.clear();

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