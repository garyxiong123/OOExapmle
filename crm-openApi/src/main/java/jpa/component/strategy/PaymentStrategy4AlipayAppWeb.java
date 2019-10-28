package jpa.component.strategy;

import jpa.annotation.StrategyNum;
import org.springframework.stereotype.Component;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/21 下午3:19
 */
@Component
@StrategyNum(superClass = PaymentStrategy.class, number = "1", describe = "默认策略:保持一个登录(不同的浏览器登录,后者剔出前者)")
public class PaymentStrategy4AlipayAppWeb implements PaymentStrategy {
    @Override
    public Payment executePay(Payment payment) {

        return payment;
    }
}
