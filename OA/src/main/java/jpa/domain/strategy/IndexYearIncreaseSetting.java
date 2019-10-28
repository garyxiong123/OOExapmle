package jpa.domain.strategy;

import jpa.domain.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/26 下午1:57
 */


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
public class IndexYearIncreaseSetting extends BaseEntity {

    @OneToOne
    private IncreaseStrategy4UnFix increaseStrategy4UnFix;


    /**
     * 第几年
     */
    private int indexYear;

    /**
     * 增长比例
     */
    private int increasePercert;

}
