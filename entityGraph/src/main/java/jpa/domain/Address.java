package jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author: xiongchengwei
 * @version:
 * @Description: 类的主要职责说明
 * @Date: 2020/2/9 下午9:35
 */
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@Entity
public class Address{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String addressName;

}
