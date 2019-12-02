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
public class DeployCommandLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "deployCommand_id")
    private DeployCommand deployCommand;
}
