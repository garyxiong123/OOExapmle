package jpa.util;


import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;
import static java.util.Objects.isNull;
import static jpa.util.ObjectUtil.requireNonNulls;

/**
 * @author panqingqing
 * @version v1.0
 * @date 2018年12月5日 下午10:00:00
 * @work 钱工具类
 */
public class MoneyUtil {

    /**
     * 判断 source 小于 0
     * source == null return false
     * true: source < 0
     * false: source >= 0
     *
     * @param source
     * @return
     */
    public static boolean ltZero(BigDecimal source) {
        return lt(source, ZERO);
    }

    /**
     * 判断 source 小于等于 0
     * source == null return false
     * true: source <= 0
     * false: source > 0
     *
     * @param source
     * @return
     */
    public static boolean ltEqZero(BigDecimal source) {
        return ltEq(source, ZERO);
    }

    /**
     * 判断 source 大于 0
     * source == null return false
     * true: source > 0
     * false: source <= 0
     *
     * @param source
     * @return
     */
    public static boolean gtZero(BigDecimal source) {
        return gt(source, ZERO);
    }

    /**
     * 判断 source 大于等于 0
     * source == null return false
     * true: source >= 0
     * false: source < 0
     *
     * @param source
     * @return
     */
    public static boolean gtEqZero(BigDecimal source) {
        return gtEq(source, ZERO);
    }

    /**
     * 判断 source 等于 0
     * source == null return false
     * true: source == 0
     * false: source != 0
     *
     * @param source
     * @return
     */
    public static boolean eqZero(BigDecimal source) {
        return eq(source, ZERO);
    }

    /**
     * 判断 source 小于 target
     * source == null || target == null return false
     * true: source < target
     * false: source >= target
     *
     * @param source
     * @param target
     * @return
     */
    public static boolean lt(BigDecimal source, BigDecimal target) {
        if (isNull(source) || isNull(target)) return false;
        return source.compareTo(target) < 0;
    }

    /**
     * 判断 source 大于 target
     * source == null || target == null return false
     * true: source > target
     * false: source <= target
     *
     * @param source
     * @param target
     * @return
     */
    public static boolean gt(BigDecimal source, BigDecimal target) {
        if (isNull(source) || isNull(target)) return false;
        return source.compareTo(target) > 0;
    }

    /**
     * 判断 source 等于 target
     * source == null || target == null return false
     * true: source == target
     * false: source != target
     *
     * @param source
     * @param target
     * @return
     */
    public static boolean eq(BigDecimal source, BigDecimal target) {
        if (isNull(source) || isNull(target)) return false;
        return source.compareTo(target) == 0;
    }

    /**
     * 判断 source 小于等于 target
     * source == null || target == null return false
     * true: source <= target
     * false: source > target
     *
     * @param source
     * @param target
     * @return
     */
    public static boolean ltEq(BigDecimal source, BigDecimal target) {
        if (isNull(source) || isNull(target)) return false;
        return !gt(source, target);
    }

    /**
     * 判断 source 大于等于 target
     * source == null || target == null return false
     * true: source >= target
     * false: source < target
     *
     * @param source
     * @param target
     * @return
     */
    public static boolean gtEq(BigDecimal source, BigDecimal target) {
        if (isNull(source) || isNull(target)) return false;
        return !lt(source, target);
    }

    /**
     * 返回 source - target 不控制精度
     *
     * @param source
     * @param target
     * @return
     */
    public static BigDecimal subtract(BigDecimal source, BigDecimal target) {
        requireNonNulls(source, target);
        return source.subtract(target);
    }

    /**
     * 返回 source - 多个target 不控制精度
     *
     * @param source
     * @param targets
     * @return
     */
    public static BigDecimal multiSubtract(BigDecimal source, BigDecimal... targets) {
        requireNonNulls(source);
        requireNonNulls(targets);
        for (BigDecimal target : targets) {
            source = source.subtract(target);
        }
        return source;
    }

    /**
     * 返回 source * target 不控制精度
     *
     * @param source
     * @param target
     * @return
     */
    public static BigDecimal multiply(BigDecimal source, BigDecimal target) {
        requireNonNulls(source, target);
        return source.multiply(target);
    }

    /**
     * 返回 source * targets 不控制精度
     *
     * @param source
     * @param targets
     * @return
     */
    public static BigDecimal multiMultiply(BigDecimal source, BigDecimal... targets) {
        requireNonNulls(source);
        requireNonNulls(targets);
        for (BigDecimal target : targets) {
            source = source.multiply(target);
        }
        return source;
    }

    /**
     * 返回 source + target 不控制精度
     *
     * @param source
     * @param target
     * @return
     */
    public static BigDecimal add(BigDecimal source, BigDecimal target) {
        requireNonNulls(source, target);
        return source.add(target);
    }

    /**
     * 取source 和 target 之间较小的一个
     *
     * @param source
     * @param target
     * @return
     */
    public static BigDecimal min(BigDecimal source, BigDecimal target) {
        requireNonNulls(source, target);
        return gtEq(source, target) ? target : source;
    }

    /**
     * 取source 和 target 之间较大的一个
     *
     * @param source
     * @param target
     * @return
     */
    public static BigDecimal max(BigDecimal source, BigDecimal target) {
        requireNonNulls(source, target);
        return gtEq(source, target) ? source : target;
    }

    /**
     * 将字符串转化为BigDecimal
     *
     * @return
     */
    public static BigDecimal string2BigDecimal(String string) {
        return new BigDecimal(string);
    }

    /**
     * 判断source在left和right之间,开区间
     *
     * @param source
     * @param left
     * @param right
     * @return
     */
    public static boolean betweenLeftRight(BigDecimal source, BigDecimal left, BigDecimal right) {
        requireNonNulls(source, left, right);
        return (gtEq(source, left) && ltEq(source, right)) ? true : false;
    }

    /**
     * 判断数值是否整形
     *
     * @param decimalVal
     * @return
     */
    public static boolean isIntegerValue(BigDecimal decimalVal) {
        if (isNull(decimalVal)) {
            return false;
        }
        return decimalVal.scale() <= 0 || decimalVal.stripTrailingZeros().scale() <= 0;
    }
}
