package jpa.repository;

import jpa.domain.Merchant;
import jpa.domain.PaymentOrg;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/21 下午4:09
 */
public interface PaymentOrgRepository extends JpaRepository<PaymentOrg, Long> {

}
