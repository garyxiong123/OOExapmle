package jpa.override;

import jpa.domain.Bird;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: xiongchengwei
 * @version:
 * @Description: 类的主要职责说明
 * @Date: 2020/2/8 下午12:29
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@DiscriminatorValue("User")
public class User extends Person {

    @ManyToOne
    private Bird animal;

    private String userName;


    public static void main(String[] args) {
        User user = new User();
    }
}
