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
@Data
@Entity
@DiscriminatorValue("rollback")
public class DeployCommand4Rollback extends DeployCommand {

    private String rollBackTest;
    public DeployCommand4Rollback(DeployCommandReqDto deployCommandReqDto) {
        super(deployCommandReqDto);

    }
}
