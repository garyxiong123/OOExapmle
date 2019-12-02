package jpa.repository;

import com.google.common.collect.Sets;
import jpa.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/8 下午1:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    private String city = "shanghai";
    private String username = "熊成威";
    private String username1 = "zhangsan";
    String departmentName = "采购部";
    String departmentLocation = "张江";
    String roleName = "普通角色";


    // @Rollback(false)
    @Before
    public void saveTest() throws Exception {
        User user = createUserWithExtInfo();
        userRepository.save(user);

        User user1 = createUserWithExtInfo();
        user1.setUsername(username1);
        userRepository.save(user1);
    }

    @Test
    public void testSqlQuery() {
        List<User> user = userRepository.findByUsername(this.username);
        Assert.assertNotNull(user);
    }


    @Test
    public void testRelateQuery() {
        Set<Role> roles = createRoles();
        User user = (User) userRepository.findUsersByRoles(roles);
        Assert.assertNotNull(user);

    }

    @Test
    public void testRelateQuery4RoleAdmin() {
        List<Role> roles = roleRepository.findRolesByRoleName(roleName);
        Assert.assertNotNull(roles.get(0).getUsers());

    }

    @Test
    public void testRelateQuery4ManyToOne() {
        List<User> user = userRepository.findUsersByDepartmentName(this.departmentName);
        Assert.assertNotNull(user);

        List<User> user1 = userRepository.findUsersByDepartmentNameAndDepartmentLocation(this.departmentName, this.departmentLocation);
        Assert.assertNotNull(user1);

    }

    @Test
    public void testRelateQuery4ManyToMany() {

    }



    //    @Test
//    public void testRelateQueryWithObj(){
//        User user = userRepository.findUsersByRealName("普通角色");
//        Assert.assertNotNull(user);
//
//    }
//
    @Test
    public void testRelateQueryWithVOObj() {
        AddressVO adressVo = createAdressVo();
        List<User> user = userRepository.findUsersByAddressVO(adressVo);
        Assert.assertNotNull(user);

    }

    @Test
    public void testRelateQueryWithVOObjValue() {
        List<User> user = userRepository.findUsersByAddressVO_City(this.city);
        Assert.assertNotNull(user);

    }

    @Test
    public void testRelateQueryWithVOObjValueInPage() {
        Pageable page = PageRequest.of(1, 10);
        Page<User> user = userRepository.findFirstByAddressVO_City(this.city, page);
        Assert.assertNotNull(user);

    }

    /**
     * 随意的命名， 证明 jpa 不是更加命名来执行， 而是根据 入参数，和 出参数来决定的
     */
    @Test
    public void testRelateQueryWithVOObjValueWithOptionReturn() {
        Optional<List<User>> user = userRepository.findOptionalUsersByAddressVO_City(this.city);
        Assert.assertNotNull(user);

    }


    @Rollback(false)
    @Test
    public void deleteRelationTest() throws Exception {
        User user = User.builder().phone("1222").build();
        user.setCreateAuthor("熊成威");
        Set<Role> roles = createRoles();
        user.setRoles(roles);
        userRepository.save(user);
        userRepository.deleteById(user.getId());

    }

    @Test
    public void findAllTest() {
        List<User> users = userRepository.findAll();
        System.out.println(users);
    }


    private User createUserWithExtInfo() {
        User user = User.builder().phone("1222").build();
        user.setCreateAuthor(username);
        user.setUsername(username);

        AddressVO adress = createAdressVo();
        user.setAddressVO(adress);

        Set<Role> roles = createRoles();
        user.setRoles(roles);

        HashMap extInfo = createExtInfo();
        user.setExtInfo(extInfo);

        Department department = createDepartment();
        user.setDepartment(department);

        return user;
    }

    private Department createDepartment() {

        return Department.builder().location(departmentLocation).name(departmentName).build();
    }

    private HashMap createExtInfo() {
        HashMap extInfo = new HashMap();
        extInfo.put("ss", "ttt");
        extInfo.put("ss1", "ttt");
        return extInfo;
    }

    private AddressVO createAdressVo() {
        return new AddressVO("11", "莲花路", this.city, "minghang");
    }


    private Set<Role> createRoles() {
        Set<Permission> permissions = createPermissions();

        Role role = Role.builder().roleName("普通角色").permissions(permissions).build();
        Set<Role> roles = Sets.newHashSet(role);

        return roles;
    }

    private Set<Permission> createPermissions() {
        Set<Permission> permissions = new HashSet<>();
        Permission permission = Permission.builder().permissionName("新增").build();
        permissions.add(permission);
        return permissions;
    }


}