package jpa.domain.strategy;

import jpa.annotation.StrategyNum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/26 上午9:45
 */


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@DiscriminatorValue("PaymentType4FixAmount")
public class PaymentType4FixAmount extends PaymentType {


    private BigDecimal fixPrice;


    @Override
    public BigDecimal doPriceCaculate() {
        return fixPrice;
    }


}
