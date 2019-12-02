package jpa.repository;

import com.google.common.collect.Sets;
import jpa.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/8 下午1:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PermissonRepositoryTest {

    @Autowired
    private PermissionRepository permissionRepository;

    /**
     * 类继承模式，权限， 按钮，接口，页面
     */
    @Test
    public void classExtendTest() {

        Permission4Menu permission4Menu = createPermission4Menu();
        permissionRepository.save(permission4Menu);

        Permission4Data permission4Data = createPermission4Data();
        permissionRepository.save(permission4Data);
        Permission4Function permission4Function = createPermission4Function();
        permissionRepository.save(permission4Function);

        List<Permission> permissions = permissionRepository.findAll();
        System.out.println(permissions);
    }

    private Permission4Function createPermission4Function() {
        Permission4Function permission4Function = new Permission4Function("11");
        return permission4Function;
    }

    private Permission4Data createPermission4Data() {

        Permission4Data permission4Data = new Permission4Data("11", "22");
        permission4Data.setCode("管理页面");
        permission4Data.setPermissionName("1222");
        return permission4Data;
    }

    private Permission4Menu createPermission4Menu() {
        Permission4Menu permission4Menu = new Permission4Menu("11", "22");
        permission4Menu.setCode("管理页面");
        permission4Menu.setPermissionName("1222");

        return permission4Menu;

    }


}