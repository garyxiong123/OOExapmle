package jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/9 下午1:41
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@DiscriminatorValue("Bird")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "birdType", discriminatorType = DiscriminatorType.STRING, length = 30)
public class Bird extends Animal {

    @Column
    private String birdName;

}
