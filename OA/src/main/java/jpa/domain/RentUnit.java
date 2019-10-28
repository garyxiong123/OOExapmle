package jpa.domain;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/26 上午10:56
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
public class RentUnit extends BaseEntity {


    private String address;
    /**
     * 面积
     */
    private String acreage;

    @OneToMany(cascade = CascadeType.ALL)
    private List<RentUnitContractItem> rentUnitContractItemList;

    @ManyToOne(cascade = CascadeType.ALL)
    private Contract contract;
}
