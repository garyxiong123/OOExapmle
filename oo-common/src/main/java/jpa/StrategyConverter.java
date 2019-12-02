package jpa;

import jpa.annotation.StrategyNum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;

import static java.util.Objects.isNull;
import static jpa.bean.StrategyNumBean.getBeanByName;
import static jpa.bean.StrategyNumBean.getCombineKey;
import static org.apache.commons.lang.StringUtils.isBlank;
import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/10 下午3:25
 */
@Component
public class StrategyConverter implements AttributeConverter<Object, String> ,Converter<String, Object> {


    @Override
    public String convertToDatabaseColumn(Object attribute) {
        if(isNull(attribute)){
            return null;
        }
        StrategyNum strategyNum = findAnnotation(attribute.getClass(), StrategyNum.class);
        String combineKey = getCombineKey(strategyNum);
        return combineKey;
    }

    @Override
    public Object convertToEntityAttribute(String combineKey) {
        if (isBlank(combineKey)) {
            return null;
        }
        return getBeanByName(combineKey);
    }

    @Override
    public Object convert(String source) {
        return null;
    }
}
