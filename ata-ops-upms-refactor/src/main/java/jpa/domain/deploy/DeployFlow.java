package jpa.domain.deploy;

import jpa.domain.vo.DeployFlowImageVO;
import jpa.domain.vo.DeployFlowJenkinsVO;
import jpa.domain.vo.DeployFlowMarathonVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/9 下午5:19
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class DeployFlow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "deployCommand_id")
    private DeployCommand deployCommand;

    private DeployFlowImageVO deployFlowImageVO;

    private DeployFlowJenkinsVO deployFlowJenkinsVO;

    private DeployFlowMarathonVO deployFlowMarathonVO;

}
