package jpa.domain;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: xiongchengwei
 * @Date: 2019/11/21 下午9:49
 */
public class PromotionType4Discount extends PromotionType {


    private int quantity;


    private float discount;


    @Override
    public BigDecimal caculatePrice(List<Product> products) {

        return null;
    }

}
