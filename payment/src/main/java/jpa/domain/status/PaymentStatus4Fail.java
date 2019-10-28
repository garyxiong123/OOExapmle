package jpa.domain.status;

import jpa.annotation.StrategyNum;
import org.springframework.stereotype.Component;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/21 下午2:58
 */
@StrategyNum(superClass = PaymentStatus.class, number = "3", describe = "失败")
@Component
public class PaymentStatus4Fail extends PaymentStatus {
}
