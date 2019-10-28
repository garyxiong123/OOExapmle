package jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/26 上午9:42
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@DiscriminatorValue("ContractItem4WaterFee")
public class RentUnitContractItem4WaterFee extends RentUnitContractItem {
    private String waterFeeName;

    @Override
    public BigDecimal caculcateReceivable() {
        return null;
    }
}
