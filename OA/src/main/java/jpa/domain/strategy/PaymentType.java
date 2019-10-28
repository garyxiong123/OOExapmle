package jpa.domain.strategy;

import jpa.domain.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.math.BigDecimal;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/26 上午9:39
 */

@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class PaymentType extends BaseEntity implements PriceCaculate {
    @Override
    public BigDecimal doPriceCaculate() {
        return null;
    }
}
