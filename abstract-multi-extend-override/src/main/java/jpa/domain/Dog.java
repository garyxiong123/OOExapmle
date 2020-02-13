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
@DiscriminatorValue("Dog")
public class Dog extends Animal {

    @Column
    private String birdName;

}
