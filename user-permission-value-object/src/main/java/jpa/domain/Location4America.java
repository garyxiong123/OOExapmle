package jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Embeddable;

/**
 * @Author: xiongchengwei
 * @version:
 * @Description: 类的主要职责说明
 * @Date: 2020/5/26 下午8:49
 */
@Embeddable
@Data
public class Location4America extends Location {

    private String america;

    public Location4America() {
    }

//    @Builder
    public Location4America(String name, String age, String america) {
        super(name, age);
        this.america = america;
    }
}
