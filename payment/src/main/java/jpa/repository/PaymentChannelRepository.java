package jpa.repository;

import jpa.domain.PaymentChannel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/21 下午4:09
 */
public interface PaymentChannelRepository extends JpaRepository<PaymentChannel, Long> {

    PaymentChannel findPaymentChannelByCode(String code);
}
