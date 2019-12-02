//package jpa.repository;
//
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * @Author: xiongchengwei
// * @Date: 2019/10/9 下午1:44
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Slf4j
//public class StudentRepositoryTest {
//    @Autowired
//    private StudentRepository studentRepository;
//
//    @Before
//    public void setUp() throws Exception {
//
//    }
//
//
//    @Rollback(false)
//    @Test
//    public void saveTest() throws Exception {
//
//        Student student = new Student("ss");
//        student.setEmail("502238410");
//        studentRepository.save(student);
//    }
//
//
//}