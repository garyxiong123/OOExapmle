package jpa.service;

import jpa.domain.Order;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/25 下午10:05
 */
public class OrderService {


    public String transfrom(String xml) {
        String type = getTypeFromXml();

        Order order = getOrderByType(type);

        String soapXml = order.transform();

        return soapXml;

    }

    private Order getOrderByType(String type) {
        return null;
    }

    private String getTypeFromXml() {
        return null;
    }


}
