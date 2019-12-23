package jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/9 下午3:21
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Address extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String country;
    private String province;
    private String city;
    private String detail;
}
