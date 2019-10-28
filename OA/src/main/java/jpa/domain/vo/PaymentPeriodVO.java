package jpa.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;


/**
 * @Author: xiongchengwei
 * @Date: 2019/10/26 上午9:39
 */


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Embeddable
public class PaymentPeriodVO {
    /**
     * 单位 按月，默认一个月
     */
    private int paymentPeriodNum = 1;

}
