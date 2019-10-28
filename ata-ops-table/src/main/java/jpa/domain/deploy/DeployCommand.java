package jpa.domain.deploy;

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
public class DeployCommand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long appId;

    private Long envId;

//    @Column(name = "event")
//    private AppOperationEnum event;
//
//    @Column(name = "status")
//    private AppOperationEventStatusEnum status;

    private String detail;

    private DeployCommandDetailVO deployCommandDetailVO;

    private DeployCommandCallbackVO deployCommandCallbackVO;

    private DeployCommandConfigVO deployCommandConfigVO;
}
