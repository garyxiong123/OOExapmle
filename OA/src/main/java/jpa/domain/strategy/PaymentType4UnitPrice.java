package jpa.domain.strategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/26 上午9:46
 */


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@DiscriminatorValue("PaymentType4UnitPrice")
public class PaymentType4UnitPrice extends PaymentType {

    private float unit;

    private BigDecimal unitPrice;

    @Override
    public BigDecimal doPriceCaculate() {

        BigDecimal test = new BigDecimal(unit);
        return test.multiply(unitPrice);
    }
}
