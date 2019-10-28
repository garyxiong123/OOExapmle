package jpa.repository;

import jpa.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/21 下午4:09
 */
public interface MerchantRepository extends JpaRepository<Order, Long> {

}
