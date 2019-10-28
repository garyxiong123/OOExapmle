package jpa.status;

import jpa.annotation.StrategyNum;
import org.springframework.stereotype.Component;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/11 下午3:08
 */

@StrategyNum(superClass = DeployStatus.class, number = "1", describe = "处理中")
@Component
public class DeployStatus4Processing extends DeployStatus {
}
