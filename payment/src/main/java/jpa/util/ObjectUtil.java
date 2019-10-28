package jpa.util;

import static java.util.Objects.requireNonNull;

/**
 * @author panqingqing
 * @version v1.0
 * @date 2018年12月5日 下午10:00:00
 * @work 对象工具类
 */
public class ObjectUtil {

    /**
     * 确保objects都不为null
     *
     * @param objects
     */
    public static void requireNonNulls(Object... objects) {
        for (Object object : objects) {
            requireNonNull(object);
        }
    }
}
