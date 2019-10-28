package jpa.repository;

import jpa.domain.PaymentOrg;
import jpa.domain.PaymentOrgConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/21 下午4:09
 */
public interface PaymentOrgConfigRepository extends JpaRepository<PaymentOrgConfig, Long> {

}
