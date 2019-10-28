package jpa.domain;

import javax.persistence.DiscriminatorValue;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/25 下午10:03
 */
@DiscriminatorValue("新装销售平")
public class Order4NewSalesProduct extends Order4New {


    private String salesProductName;


    @Override
    public String transform() {

        return "";
    }


}
