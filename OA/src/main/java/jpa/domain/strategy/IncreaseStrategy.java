package jpa.domain.strategy;

import jpa.domain.BaseEntity;
import jpa.domain.RentUnitContractItem;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/26 下午12:46
 */
@NoArgsConstructor
@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class IncreaseStrategy extends BaseEntity {

    private String name;

    public double increaseCaculate(LocalDateTime contractTime) {
        return 0;
    }

}
