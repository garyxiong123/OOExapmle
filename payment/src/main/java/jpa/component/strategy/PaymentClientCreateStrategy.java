package jpa.component.strategy;

import jpa.domain.PaymentOrgConfig;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/23 上午8:43
 */
public interface PaymentClientCreateStrategy {
    <T> T createPaymentClient(PaymentOrgConfig paymentOrgConfig);
}
