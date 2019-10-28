package jpa;

import jpa.annotation.StrategyNum;

import javax.persistence.AttributeConverter;

import static jpa.bean.StrategyNumBean.getBeanByName;
import static jpa.bean.StrategyNumBean.getCombineKey;
import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/10 下午3:25
 */
public class StrategyConverter implements AttributeConverter<Object, String> {


    @Override
    public String convertToDatabaseColumn(Object attribute) {
        StrategyNum strategyNum = findAnnotation(attribute.getClass(), StrategyNum.class);
        String combineKey = getCombineKey(strategyNum);
        return combineKey;
    }

    @Override
    public Object convertToEntityAttribute(String combineKey) {
        return getBeanByName(combineKey);
    }
}
