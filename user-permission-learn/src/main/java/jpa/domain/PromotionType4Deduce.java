package jpa.domain;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: xiongchengwei
 * @Date: 2019/11/21 下午9:49
 */
public class PromotionType4Deduce extends PromotionType {


    private int quantity;

    private int deduceAmount;

    @Override
    public BigDecimal caculatePrice(List<Product> products) {

        BigDecimal disconutPrice;
        BigDecimal totalOriginalPrice = caculateTotalPrice(products);
        if (quantity > products.size()) {

            disconutPrice = totalOriginalPrice.subtract(BigDecimal.valueOf(deduceAmount));
        }


        return null;
    }

    private BigDecimal caculateTotalPrice(List<Product> products) {
        return null;
    }


}
