package jpa.repository;

import com.google.common.collect.Sets;
import jpa.domain.deploy.DeployCommand;
import jpa.domain.upms.Permission;
import jpa.domain.upms.Role;
import jpa.domain.upms.User;
import jpa.repository.deploy.DeployCommandRepository;
import jpa.status.DeployStatus;
import jpa.status.DeployStatus4Succ;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
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
public class DeployCommanRepositoryTest {

    @Autowired
    private DeployCommandRepository deployCommandRepository;

    @Before
    public void before() {
        System.getProperties().setProperty("spring.application.name", "ss");
    }

    @Rollback(false)
    @Test
    public void saveStatusTest() throws Exception {
        DeployCommand depploy = DeployCommand.builder().appId(1L).detail("sssd").build();
        DeployStatus depployStatus = new DeployStatus4Succ();
        depploy.setDeployStatus(depployStatus);
        deployCommandRepository.save(depploy);
        Assert.assertNotNull(depploy.getDeployStatus());
    }

}