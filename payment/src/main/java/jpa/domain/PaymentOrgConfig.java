package jpa.domain;

import jpa.StrategyConverter;
import jpa.component.strategy.PaymentClientCreateStrategy;
import lombok.*;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/23 上午8:41
 */

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class PaymentOrgConfig extends BaseEntity{


    /**
     * 支付机构id
     */
    private Long paymentOrgId;

    /**
     * 通知地址
     */
    private String notifyUrl;

    /**
     * 账单文件地址
     */
    private String billFilePath;

    /**
     * 支付对象配置策略
     */
    @Convert(converter = StrategyConverter.class)
    private PaymentClientCreateStrategy paymentClientCreateStrategy;

    /**
     * 支付机构配置参数信息
     */
//    @MapKeyClass(value = String.class)
//    @MapKeyColumn(name="param_map")
    @Lob
    private HashMap paramMap;

    public <T> T createPaymentObject() {
        return paymentClientCreateStrategy.createPaymentClient(this);
    }

}
