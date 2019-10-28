package jpa.component.strategy;

import jpa.domain.Payment;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/21 下午3:17
 */
public interface PaymentStrategy {

    Payment executePay(Payment payment);


}
