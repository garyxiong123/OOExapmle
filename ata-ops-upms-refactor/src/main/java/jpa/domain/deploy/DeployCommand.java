package jpa.domain.deploy;

import jpa.StrategyConverter;
import jpa.domain.BasicStatusEnum;
import jpa.domain.vo.DeployCommandCallbackVO;
import jpa.domain.vo.DeployCommandDetailVO;
import jpa.dto.DeployCommandReqDto;
import jpa.status.DeployStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/9 下午5:19
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "deployCommand")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING, length = 30)
public class DeployCommand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long appId;

    private Long envId;

    @Convert(converter = StrategyConverter.class)
    private DeployStatus deployStatus;

    private String detail;

    private DeployCommandDetailVO deployCommandDetailVO;

    private DeployCommandCallbackVO deployCommandCallbackVO;


    public DeployCommand(DeployCommandReqDto deployCommandReqDto) {
        this.appId = deployCommandReqDto.getAppId();
        this.envId = deployCommandReqDto.getEnvId();
    }

    public void execute() {
        processDeploy();

        createDeployFlowsAndPublishEvent();
    }

    protected void processDeploy() {
//        deployEntity.setStatus(BasicStatusEnum.PROCESS);
//        deployEntity.setUpdateTime(LocalDateTime.now());
//        deployCommandMapper.insertSelective(deployEntity);
    }

    protected void createDeployFlowsAndPublishEvent() {
//        List<DeployFlowEntity> deployFlowEntities = createFlows(deployConfigId, deployFlowExecStrategyList);
//        eventPublisher.publishEvent(new FlowEvent4StartDeploy(this, deployFlowEntities.get(0)));
    }
}
