package jpa.domain.strategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/26 下午12:48
 */
@Data
@Entity
@DiscriminatorValue("IncreaseStrategy4UnFix")
public class IncreaseStrategy4UnFix extends IncreaseStrategy {

    private String test;

    public IncreaseStrategy4UnFix() {
        super();
    }

    @OneToMany
    private List<IndexYearIncreaseSetting> indexYearIncreaseSettings;


    @Override
    public double increaseCaculate(LocalDateTime contractTime) {


        return 12;
    }
}
