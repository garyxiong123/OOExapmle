package jpa.domain;

import jpa.StrategyConverter;
import jpa.component.strategy.PaymentStrategy;
import lombok.*;

import javax.persistence.*;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/21 下午3:02
 */

@NoArgsConstructor
@Setter
@Getter
@Entity
public class PaymentChannel extends BaseEntity {

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private PaymentOrg paymentOrg;

    private String code;

    @Convert(converter = StrategyConverter.class)
    private PaymentStrategy paymentStrategy;

    public void pay(Payment payment) {
        paymentStrategy.executePay(payment);
    }

    public PaymentChannel(PaymentOrg paymentOrg, String code, PaymentStrategy paymentStrategy) {
        this.paymentOrg = paymentOrg;
        this.code = code;
        this.paymentStrategy = paymentStrategy;
    }
}
