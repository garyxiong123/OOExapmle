package jpa.domain;

import lombok.*;

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
public class Merchant extends BaseEntity{

    private String name;


}
