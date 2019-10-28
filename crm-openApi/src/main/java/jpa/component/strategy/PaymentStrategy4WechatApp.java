//package jpa.component.strategy;
//
//import com.alipay.api.AlipayApiException;
//import com.alipay.api.AlipayClient;
//import com.alipay.api.domain.AlipayTradeAppPayModel;
//import com.alipay.api.request.AlipayTradeAppPayRequest;
//import com.alipay.api.response.AlipayTradeAppPayResponse;
//import jpa.annotation.StrategyNum;
//import jpa.domain.Payment;
//import jpa.domain.Payment4Alipay;
//import jpa.domain.Payment4Wechat;
//import jpa.domain.PaymentOrgConfig;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import static jpa.component.flyweight.PaymentClientFlyweightFactory.getPaymentClientFlyweight;
//import static jpa.help.constant.AlipayConstant.ALIPAY_PRODUCT_CODE;
//import static org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace;
//import static org.apache.commons.lang3.StringUtils.defaultIfBlank;
//import static org.apache.commons.lang3.StringUtils.isNoneBlank;
//
///**
// * @Author: xiongchengwei
// * @Date: 2019/10/21 下午3:18
// */
//@Slf4j
//@Component
//@StrategyNum(superClass = PaymentStrategy.class, number = "3", describe = "微信支付)")
//public class PaymentStrategy4WechatApp implements PaymentStrategy {
//    @Override
//    public Payment executePay(Payment payment) {
//        Payment4Wechat payment4Alipay = (Payment4Wechat) payment;
//        payment4Alipay.callPaying();//支付中， 状态调整为  支付中
//
//        AlipayClient alipayClient = getPaymentClientFlyweight(payment.getPaymentChannel().getPaymentOrg().getPaymentOrgConfig().getId());
//        AlipayTradeAppPayRequest alipayTradeAppPayRequest = getAlipayTradeAppPayRequest(payment4Alipay);
//        try {
//            AlipayTradeAppPayResponse alipayTradeAppPayResponse = alipayClient.sdkExecute(alipayTradeAppPayRequest);
//            String syncResponseBody = alipayTradeAppPayResponse.getBody();
//            payment4Alipay.callPrepaymentSucc(syncResponseBody);//调整状态，方便落库
//        } catch (AlipayApiException ex) {
//            log.error("调用支付宝App预支付的支付编号:[{}]和异常信息:[{}]", payment4Alipay.getId(), getFullStackTrace(ex));
//            payment4Alipay.callPrepaymentFail("调用支付宝App预支付错误码:" + ex.getErrCode() + "和错误信息:" + ex.getErrMsg());
//        }
//
//
//        return payment;
//    }
//
//    private AlipayTradeAppPayRequest getAlipayTradeAppPayRequest(Payment4Alipay payment4Alipay) {
//        AlipayTradeAppPayRequest alipayTradeAppPayRequest = new AlipayTradeAppPayRequest();
//        AlipayTradeAppPayModel alipayTradeAppPayModel = getAlipayTradeAppPayModel(payment4Alipay);
//        alipayTradeAppPayRequest.setBizModel(alipayTradeAppPayModel);
//        PaymentOrgConfig paymentOrgConfig = payment4Alipay.getPaymentChannel().getPaymentOrg().getPaymentOrgConfig();
//        alipayTradeAppPayRequest.setNotifyUrl(paymentOrgConfig.getNotifyUrl());
//        return alipayTradeAppPayRequest;
//    }
//
//    private AlipayTradeAppPayModel getAlipayTradeAppPayModel(Payment4Alipay payment4Alipay) {
//        AlipayTradeAppPayModel alipayTradeAppPayModel = new AlipayTradeAppPayModel();
//        alipayTradeAppPayModel.setSubject(payment4Alipay.getAlipaySubject());
//        alipayTradeAppPayModel.setOutTradeNo(payment4Alipay.getOrderId());
//        if (isNoneBlank(payment4Alipay.getAlipayTimeoutExpress())) {
//            alipayTradeAppPayModel.setTimeoutExpress(payment4Alipay.getAlipayTimeoutExpress());
//        }
//        alipayTradeAppPayModel.setTotalAmount(payment4Alipay.getOrderAmount().toString());
//        alipayTradeAppPayModel.setProductCode(ALIPAY_PRODUCT_CODE);
//        alipayTradeAppPayModel.setGoodsType(defaultIfBlank(payment4Alipay.getAlipayGoodsType(), "1"));
//        return alipayTradeAppPayModel;
//    }
//}
