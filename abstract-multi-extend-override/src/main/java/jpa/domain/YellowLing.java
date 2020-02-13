package jpa.domain;

import jpa.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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
@DiscriminatorValue("YellowLing")
public class YellowLing extends Bird {

    private String yellowLingName;


    @Enumerated(EnumType.STRING)
    private Gender gender;


}
