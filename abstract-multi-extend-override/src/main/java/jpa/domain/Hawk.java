package jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @Author: xiongchengwei
 * @version:
 * @Description: 类的主要职责说明
 * @Date: 2020/2/8 上午11:17
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@DiscriminatorValue("Hawk")
public class Hawk extends Bird {

    private String hawkName;


}
