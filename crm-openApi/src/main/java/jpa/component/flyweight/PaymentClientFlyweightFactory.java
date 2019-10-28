package jpa.component.flyweight;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.nonNull;
import static jpa.bean.StrategyNumBean.getBeanByClass4Context;

/**
 * @author panqingqing
 * @version v1.0
 * @date 2019年3月26日 下午10:00:00
 * @work 支付对象享元工厂
 */
public class PaymentClientFlyweightFactory {

    /**
     * 支付对象享元工厂
     */
    private static Map<Long, Object> paymentObjectMap = new ConcurrentHashMap<>(16);

    /**
     * 根据支付机构id获取支付对象
     *
     * @param paymentOrgConfigId
     * @param <T>
     * @return
     */
    public static <T> T getPaymentClientFlyweight(Long paymentOrgConfigId) {
        T paymentObject = (T) paymentObjectMap.get(paymentOrgConfigId);
        if (nonNull(paymentObject)) {
            return paymentObject;
        }

        synchronized (paymentObjectMap) {
            paymentObject = (T) paymentObjectMap.get(paymentOrgConfigId);
            if (nonNull(paymentObject)) {
                return paymentObject;
            }

            PaymentOrgConfig paymentOrgConfig = getBeanByClass4Context(PaymentOrgConfigRepository.class).findById(paymentOrgConfigId).get();
            paymentObject = paymentOrgConfig.createPaymentObject();
            paymentObjectMap.put(paymentOrgConfigId, paymentObject);
        }

        return paymentObject;
    }
}
