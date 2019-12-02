package jpa.repository;

import jpa.domain.Student;
import jpa.domain.Teacher;
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
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UserRepository userRepository;

    @Before
    public void before() {
        System.getProperties().setProperty("spring.application.name", "ss");
    }


    @Rollback(false)
    @Test
    public void saveTest() throws Exception {

        Student student = new Student("ss", "sd");
        student.setEmail("502238410");
        studentRepository.save(student);
        Teacher teacher = new Teacher("ss", "sd");
        teacher.setEmail("502238410");
        userRepository.save(teacher);
    }


}