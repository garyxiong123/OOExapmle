package jpa.override;

import jpa.domain.Animal;
import jpa.domain.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * @Author: xiongchengwei
 * @version:
 * @Description: 类的主要职责说明
 * @Date: 2020/2/8 下午12:29
 */


@Data
@Entity
@Table(name = "Person")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DISCRIMINATOR", discriminatorType = DiscriminatorType.STRING, length = 30)
public class Person extends BaseEntity {

    @ManyToOne
    private Animal animal;

    private String personName;
}
