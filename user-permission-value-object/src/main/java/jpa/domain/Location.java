package jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/9 下午3:21
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Embeddable
public class Location {

    private String name;
    private String age;

}
