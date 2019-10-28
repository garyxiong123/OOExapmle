package jpa.component.strategy;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import jpa.annotation.StrategyNum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/23 上午8:45
 */
@Slf4j
@StrategyNum(superClass = PaymentClientCreateStrategy.class, number = "1", describe = "支付宝App客户端创建支付策略")
@Component
public class PaymentClientCreateStrategy4Alipay implements PaymentClientCreateStrategy {
    @Override
    public <T> T createPaymentClient(PaymentOrgConfig paymentOrgConfig) {
        Map<String, String> paramMap = paymentOrgConfig.getParamMap();

        AlipayClient alipayClient = getAlipayClient(paramMap);
        return (T) alipayClient;
    }

    /**
     * 获取支付宝支付对象
     *
     * @param paramMap 配置参数
     * @return
     */
    private AlipayClient getAlipayClient(Map<String, String> paramMap) {
        AlipayClient alipayClient = new DefaultAlipayClient(
                paramMap.get("url"),
                paramMap.get("appId"),
                paramMap.get("privateKey"),
                paramMap.get("format"),
                paramMap.get("charset"),
                paramMap.get("alipayPublicKey"),
                paramMap.get("signType")
        );
        return alipayClient;
    }
}
