//package jpa.controller;
//
//import com.youyu.common.api.Result;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import jpa.domain.deploy.DeployCommand;
//import jpa.dto.DeployCommandReqDto;
//import org.reflections.Reflections;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.persistence.DiscriminatorValue;
//import java.lang.reflect.Constructor;
//import java.util.Set;
//
//import static jpa.utils.DiscriminatorUtil.findChildByDiscriminatorType;
//import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;
//
///**
// * @Author: xiongchengwei
// * @Date: 2019/10/16 上午11:09
// */
//
//@Api(description = "发布相关接口")
//@RestController
//@RequestMapping("/deploy")
//public class DeployController {
//
//
//    @ApiOperation("发布)")
//    @PostMapping("/deploy")
//    public Result operate(@Validated @RequestBody DeployCommandReqDto deployCommandReqDto) throws Exception {
//        DeployCommand deployCommand = createDeployCommand(deployCommandReqDto);
//        deployCommand.execute();
//        System.out.printf("ss");
//        return Result.ok(null);
//    }
//
//    private DeployCommand createDeployCommand(DeployCommandReqDto deployCommandReqDto) throws Exception {
//        String type = deployCommandReqDto.getType();
//        Class childClass = findChildByDiscriminatorType(type, DeployCommand.class);
//
//        Constructor constructor = childClass.getConstructor(deployCommandReqDto.getClass());
//        DeployCommand deployCommand = (DeployCommand) constructor.newInstance(deployCommandReqDto);
//
//        return deployCommand;
//    }
//
//
//}
