package jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/21 下午3:11
 */
@Data
@Entity
@DiscriminatorValue("Payment4Wechat")
public class Payment4Wechat extends Payment {

    private String wechat;

}
