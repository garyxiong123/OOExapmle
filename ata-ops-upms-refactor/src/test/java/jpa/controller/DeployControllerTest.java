package jpa.controller;

import com.youyu.common.api.Result;
import jpa.domain.deploy.DeployCommand;
import jpa.dto.DeployCommandReqDto;
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

import static org.junit.Assert.*;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/16 下午4:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DeployControllerTest {

    @Before
    public void before() {
        System.getProperties().setProperty("spring.application.name", "ss");
    }


    @Autowired
    private DeployController deployController;


    @Rollback(false)
    @Test
    public void operate() throws Exception {
        DeployCommandReqDto deployCommandReqDto = createDeployCommandReqDto();
        Result result = deployController.operate(deployCommandReqDto);
    }

    private DeployCommandReqDto createDeployCommandReqDto() {
        DeployCommandReqDto deployCommandReqDto = new DeployCommandReqDto();
        deployCommandReqDto.setAppId(1L);
        deployCommandReqDto.setDeployConfigId(1L);
        deployCommandReqDto.setDetail("detail");
        deployCommandReqDto.setEnvId(2L);
        deployCommandReqDto.setType("complier");
        return deployCommandReqDto;
    }

}