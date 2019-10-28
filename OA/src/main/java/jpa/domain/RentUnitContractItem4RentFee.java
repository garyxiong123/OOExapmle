package jpa.domain;

import jpa.domain.strategy.IncreaseStrategy;
import jpa.repository.RentUnitRepository;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

import static jpa.bean.StrategyNumBean.getBeanByClass4Context;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/26 上午9:40
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@DiscriminatorValue("ContractItem4RentFee")
public class RentUnitContractItem4RentFee extends RentUnitContractItem {
    private String waterFeeName;

    private String address;
    /**
     * 面积
     */
    private String acreage;

    /**
     * 单位 元*天/平方
     */
    private BigDecimal rentFee;

    @OneToOne(cascade = CascadeType.ALL)
    private IncreaseStrategy increaseStrategy;


    @Override
    public BigDecimal caculcateReceivable() {
        RentUnit rentUnit = super.getRentUnit();
        double increasePercert = increaseStrategy.increaseCaculate(rentUnit.getContract().getContractTime());
        return rentFee.multiply(new BigDecimal(acreage).multiply(new BigDecimal(30))).multiply(new BigDecimal(increasePercert));
    }
}
