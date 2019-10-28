package jpa.domain.strategy;

import jpa.domain.RentUnitContractItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/26 下午12:47
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@DiscriminatorValue("IncreaseStrategy4FixIncrease")
public class IncreaseStrategy4FixIncrease extends IncreaseStrategy {
    /**
     * 每几年
     */
    private int perYear;

    /**
     * 增长比例
     */
    private int increasePercert;


    @Override
    public double increaseCaculate(LocalDateTime contractTime) {

        int indexYear = getIndexYear(contractTime);

        return Math.pow((float)1 + (float)increasePercert/100, (indexYear / perYear));
    }

    private int getIndexYear(LocalDateTime contractTime) {


        return (LocalDateTime.now().getYear() - contractTime.getYear());
    }
}
