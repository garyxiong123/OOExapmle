package jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/20 下午2:43
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Embeddable
public class PersonBody {

    private String hand;

    private String stomack;
}
