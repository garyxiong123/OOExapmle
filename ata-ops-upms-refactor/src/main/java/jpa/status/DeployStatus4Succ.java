package jpa.status;

import jpa.annotation.StrategyNum;
import org.springframework.stereotype.Component;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/11 下午3:08
 */

@StrategyNum(superClass = DeployStatus.class, number = "2", describe = "发布成功")
@Component
public class DeployStatus4Succ extends DeployStatus {
}
