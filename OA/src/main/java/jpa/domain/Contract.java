package jpa.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/26 上午9:37
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
public class Contract extends BaseEntity {


    private LocalDateTime paymentTime;

    /**
     * 合同时间
     */
    private LocalDateTime contractTime;


    @OneToMany(cascade = CascadeType.ALL)
    private List<RentUnit> rentUnits;

}
