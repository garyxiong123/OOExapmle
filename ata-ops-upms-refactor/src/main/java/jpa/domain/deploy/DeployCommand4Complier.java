package jpa.domain.deploy;

import jpa.dto.DeployCommandReqDto;
import jpa.status.DeployStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/16 上午10:40
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@DiscriminatorValue("complier")
public class DeployCommand4Complier extends DeployCommand {

    private Long deployConfigId;

    private String branch;

    private String dockerImageTag;

    public DeployCommand4Complier(DeployCommandReqDto deployCommandReqDto) {
        super(deployCommandReqDto);
        this.deployConfigId = deployCommandReqDto.getDeployConfigId();
        this.branch = deployCommandReqDto.getBranch();

    }

}
