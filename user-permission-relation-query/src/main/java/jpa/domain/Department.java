package jpa.domain;

import jpa.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author: xiongchengwei
 * @Date: 2019/12/1 下午12:15
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@Entity
public class Department extends BaseEntity {

    private String name;

    private String location;
}
