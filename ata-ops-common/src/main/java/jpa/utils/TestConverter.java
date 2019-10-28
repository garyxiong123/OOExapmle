package jpa.utils;

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
public class TestConverter implements Converter<String, Object> {


    @Override
    public Object convert(String source) {
        return null;
    }
}
