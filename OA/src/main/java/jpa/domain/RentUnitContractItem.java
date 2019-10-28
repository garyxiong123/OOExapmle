package jpa.domain;

import jpa.domain.strategy.PaymentType;
import jpa.domain.strategy.IncreaseStrategy;
import jpa.domain.vo.PaymentPeriodVO;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/26 上午9:38
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class RentUnitContractItem extends BaseEntity{


    @OneToOne(cascade = CascadeType.ALL)
    private RentUnit rentUnit;

    private PaymentPeriodVO paymentPeriodVO;


    @OneToOne(cascade = CascadeType.PERSIST)
    private PaymentType paymentType;


    public boolean isShouldNotity() {
        return true;
    }

    public BigDecimal caculcateReceivable() {
        return null;
    }
}
