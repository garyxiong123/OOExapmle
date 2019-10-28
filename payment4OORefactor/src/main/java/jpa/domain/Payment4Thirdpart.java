package jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/21 下午3:13
 */
@Data
@Entity
@DiscriminatorValue("Payment4Thirdpart")
public class Payment4Thirdpart extends Payment {
}
