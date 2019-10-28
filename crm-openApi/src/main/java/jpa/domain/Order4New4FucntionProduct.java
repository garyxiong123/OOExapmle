package jpa.domain;

import javax.persistence.DiscriminatorValue;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/25 下午10:02
 */
@DiscriminatorValue("新装功能产品")
public class Order4New4FucntionProduct extends Order4New {





    @Override
    public String transform() {

        return "";
    }

}
