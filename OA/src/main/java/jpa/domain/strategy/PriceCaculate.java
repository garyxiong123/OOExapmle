package jpa.domain.strategy;

import java.math.BigDecimal;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/26 上午9:56
 */
public interface PriceCaculate {

    BigDecimal doPriceCaculate();
}
