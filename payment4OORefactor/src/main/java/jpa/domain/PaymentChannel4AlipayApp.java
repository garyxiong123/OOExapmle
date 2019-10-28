package jpa.domain;

import jpa.component.strategy.PaymentStrategy;
import lombok.*;

import javax.persistence.Entity;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/23 上午11:48
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class PaymentChannel4AlipayApp extends PaymentChannel {


    @Override
    public void pay(Payment payment) {
        super.pay(payment);
    }
}
