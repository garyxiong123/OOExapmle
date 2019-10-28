package jpa.repository;

import jpa.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/21 下午4:09
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
