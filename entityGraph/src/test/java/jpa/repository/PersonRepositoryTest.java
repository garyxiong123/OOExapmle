package jpa.repository;

import jpa.domain.Address;
import jpa.domain.Card;
import jpa.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/9 下午1:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    @Before
    public void setUp() throws Exception {

    }


    @Rollback(false)
    @Test
    public void saveTest() throws Exception {
        Card card = Card.builder().cardName("cardName").build();
        List<Card> cards = new ArrayList<>();
        cards.add(card);
        Person person = Person.builder().age("23").address(Address.builder().addressName("shanghai").build()).cards(cards).build();
        personRepository.save(person);
        Person person1 = personRepository.findById(person.getId());
        System.out.println(person1);
    }


}