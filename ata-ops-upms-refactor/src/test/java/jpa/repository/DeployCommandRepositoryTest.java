package jpa.repository;

import jpa.domain.deploy.DeployCommand;
import jpa.domain.deploy.DeployCommand4Complier;
import jpa.domain.deploy.DeployCommand4Rollback;
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

import java.util.List;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/8 下午1:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DeployCommandRepositoryTest {

    @Autowired
    private DeployCommandRepository deployCommandRepository;

    @Before
    public void before() {
        System.getProperties().setProperty("spring.application.name", "ss");
    }

    @Rollback(false)
    @Test
    public void saveStatusTest() {
        DeployCommand depploy = DeployCommand.builder().appId(1L).detail("sssd").build();
        DeployStatus depployStatus = new DeployStatus4Succ();
        depploy.setDeployStatus(depployStatus);
        deployCommandRepository.save(depploy);
        Assert.assertNotNull(depploy.getDeployStatus());
    }


    @Rollback(false)
    @Test
    public void saveDeployCommand4ComplierTest() {
        DeployCommand4Complier deployCommand4Complier = createDeployCommand4Complier();
        deployCommandRepository.save(deployCommand4Complier);
        List<DeployCommand> all = deployCommandRepository.findAll();
        Assert.assertNotNull(deployCommand4Complier.getDeployStatus());
    }

    /**
     * 多态保存测试
     */
    @Rollback(false)
    @Test
    public void saveDeployCommand4MultyStateTest() {
        DeployCommand4Complier deployCommand4Complier = createDeployCommand4Complier();
        deployCommandRepository.save(deployCommand4Complier);
        DeployCommand4Rollback deployCommand4Rollback = createDeployCommand4Rollback();
        deployCommandRepository.save(deployCommand4Rollback);
        List<DeployCommand> all = deployCommandRepository.findAll();
        Assert.assertNotNull(deployCommand4Complier.getDeployStatus());
    }

    /**
     * 子对象，同样字段测试
     *
     * @return
     */
    @Rollback(false)
    @Test
    public void findDeployCommand4MultyStateTest() {
//        deployCommandRepository.findAllById();

    }

    @Rollback(false)
    @Test
    public void saveSameFieldTest() {
//        deployCommandRepository.findAllById()

    }

    private DeployCommand4Rollback createDeployCommand4Rollback() {
        DeployCommand4Rollback deployCommand4Rollback = new DeployCommand4Rollback();
        deployCommand4Rollback.setRollBackTest("roleBackTest");
        deployCommand4Rollback.setAppId(22L);
        deployCommand4Rollback.setEnvId(11L);
        return deployCommand4Rollback;
    }

    private DeployCommand4Complier createDeployCommand4Complier() {
        DeployCommand4Complier deployCommand = new DeployCommand4Complier(1L, "branch", "sss");
        deployCommand.setAppId(22L);
        deployCommand.setEnvId(11L);
//        DeployStatus depployStatus = new DeployStatus4Succ();
//        deployCommand.setDeployStatus(depployStatus);
        return deployCommand;
    }

}