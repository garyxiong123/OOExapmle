package jpa.domain;

import jpa.component.strategy.PaymentStrategy;
import lombok.*;

import javax.persistence.Entity;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/23 上午11:48
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class PaymentChannel4AlipayApp extends PaymentChannel {
    private String name;


    @Override
    public void pay(Payment payment) {
        super.pay(payment);
    }

    public PaymentChannel4AlipayApp(PaymentOrg paymentOrg, String code, PaymentStrategy paymentStrategy, String name) {
        super(paymentOrg, code, paymentStrategy);
        this.name = name;
    }
}
