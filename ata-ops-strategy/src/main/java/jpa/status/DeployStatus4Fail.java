package jpa.status;

import jpa.annotation.StrategyNum;
import org.springframework.stereotype.Component;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/11 下午3:08
 */

@StrategyNum(superClass = DeployStatus.class, number = "3", describe = "失败")
@Component
public class DeployStatus4Fail extends DeployStatus {
}
