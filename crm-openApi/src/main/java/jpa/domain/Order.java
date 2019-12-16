package jpa.domain;

import lombok.*;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/21 下午3:05
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING, length = 30)
public class Order extends BaseEntity {

    private String name;


    public String transform() {

        return "";
    }

}
