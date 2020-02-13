package jpa.enums;

/**
 * @Author: xiongchengwei
 * @version:
 * @Description: 类的主要职责说明
 * @Date: 2020/2/9 下午9:20
 */

public enum Gender {
    male("男"),
    female("女");

    private String name;

    private Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
