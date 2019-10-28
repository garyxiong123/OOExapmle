package jpa.domain.status;

import jpa.annotation.StrategyNum;
import org.springframework.stereotype.Component;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/21 下午2:59
 */
@StrategyNum(superClass = PaymentStatus.class, number = "0", describe ="未支付")
@Component
public class PaymentStatus4NonPayment extends PaymentStatus {
}
