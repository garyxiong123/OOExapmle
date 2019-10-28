package jpa.domain;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/21 下午3:07
 */

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class MerchantPayemtOrgAccount extends BaseEntity {

    /**
     * 支付机构名称
     */
    private String name;

    /**
     * 支付机构编码
     */
    private String code;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Merchant merchant;

    @ManyToOne
    private PaymentOrg paymentOrg;

    private AccountConfig accountConfig;
}
