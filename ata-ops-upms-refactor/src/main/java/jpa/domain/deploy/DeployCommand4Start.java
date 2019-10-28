package jpa.domain.deploy;

import jpa.dto.DeployCommandReqDto;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/16 上午10:41
 */
@Data
@Entity
@DiscriminatorValue("start")
public class DeployCommand4Start extends DeployCommand {

    public DeployCommand4Start(DeployCommandReqDto deployCommandReqDto) {
        super(deployCommandReqDto);

    }
}
