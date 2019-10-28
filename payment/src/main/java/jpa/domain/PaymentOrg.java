package jpa.domain;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/21 下午3:04
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class PaymentOrg extends BaseEntity {

    /**
     * 支付机构名称
     */
    private String name;

    /**
     * 支付机构编码
     */
    private String code;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private PaymentOrgConfig paymentOrgConfig;

}
