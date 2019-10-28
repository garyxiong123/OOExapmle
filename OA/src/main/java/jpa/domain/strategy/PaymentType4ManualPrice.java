package jpa.domain.strategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/26 上午9:47
 */


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@DiscriminatorValue("PaymentType4ManualPrice")
public class PaymentType4ManualPrice extends PaymentType {

    private BigDecimal manualInputPrice;

    @Override
    public BigDecimal doPriceCaculate() {
        return manualInputPrice;
    }
}
