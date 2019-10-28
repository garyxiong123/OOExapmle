//package jpa.repository;
//
//import jpa.component.strategy.PaymentClientCreateStrategy4Alipay;
//import jpa.domain.*;
//import jpa.component.strategy.PaymentStrategy4AlipayApp;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.math.BigDecimal;
//import java.util.HashMap;
//
//import static jpa.bean.StrategyNumBean.getBeanByClass4Context;
//
///**
// * @Author: xiongchengwei
// * @Date: 2019/10/8 下午1:57
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Slf4j
//public class PaymentRepositoryTest {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PaymentService paymentService;
//    @Autowired
//    private PaymentRepository paymentRepository;
//    @Autowired
//    private PaymentChannelRepository paymentChannelRepository;
//    @Autowired
//    private MerchantPayemtOrgAccountRepository merchantPayemtOrgAccountRepository;
//    private MerchantPayemtOrgAccount merchantPayemtOrgAccount;
//    private String paymentChannelCode = "payment4Alipay";
//
//    @Before
//    public void initDataPrepare() {
//        System.getProperties().setProperty("spring.application.name", "ss");
//        PaymentChannel paymentChannel = createPaymentChannel();
//        MerchantPayemtOrgAccount account = createMerchant(paymentChannel);
//
//    }
//
//    private MerchantPayemtOrgAccount createMerchant(PaymentChannel paymentChannel) {
//        Merchant merchant = Merchant.builder().name("有鱼记账").build();
//        AccountConfig accountConfig = AccountConfig.builder().billFilePath("filePath").notifyUrl("http://localhost").build();
//        merchantPayemtOrgAccount = MerchantPayemtOrgAccount.builder().accountConfig(accountConfig).merchant(merchant).paymentOrg(paymentChannel.getPaymentOrg()).build();
//        merchantPayemtOrgAccountRepository.save(merchantPayemtOrgAccount);
//        return merchantPayemtOrgAccount;
//    }
//
//    private PaymentChannel createPaymentChannel() {
//        PaymentOrg paymentOrg = PaymentOrg.builder().name("支付宝").build();
//        HashMap paramMap = createParamMap();
//
//        PaymentOrgConfig paymentOrgConfig = PaymentOrgConfig.builder().billFilePath("ss").notifyUrl("notifyUrl").paramMap(paramMap).paymentClientCreateStrategy(getBeanByClass4Context(PaymentClientCreateStrategy4Alipay.class)).build();
//        paymentOrg.setPaymentOrgConfig(paymentOrgConfig);
//        PaymentChannel paymentChannel = PaymentChannel.builder().code(paymentChannelCode).paymentStrategy(new PaymentStrategy4AlipayApp()).paymentOrg(paymentOrg).build();
//
//        paymentChannelRepository.save(paymentChannel);
//        return paymentChannel;
//    }
//
//    //    privateKey=MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCMvbfKQ4a6hVPibgw0ZVp0UEOZcYHPhvCKhgs3+u945ibNgjAA0fPFSpfjHyTq1ks5kCJMqEw68y9McXALZHvk2DVV5kp2ucwsYlQKVZ6PWTeq26k/Mzu5qmfrbgZjj/2vuYXuG41mFa0tRrk9RTDso5d2Z6UucEBq3YpwFlNe70I7AflK4LGo9p03aSEe4nLWIdJJGtsqrLX86WQGppMJc++mfcE7BEq+FqxVo+CrFOxH9RwDTccDe4pZIt/4Olq3y086AEPm+Wi2pqjvDTyfUjaSN8FwuZignSN4Qq7gapyAHLqNCRE0VigRq3bnJwj0mXkCdwJXMAtmZHw+FHObAgMBAAECggEAQmAHGcEW/Uh780HrR5q1Oj3QY8GAcxs0vl/RUqlp3x7MFgfcE8bwrI8tatP5WTePaqprQrPsn7CpEeg962GMfLTrEoP1gmDFxfjpoaYXjYuKEW5fN4s2E64mLIZLRRFXl1RrsYwU95wpfDzqh9bl5/SPLixbXrdZ6gxpics9rnt8xGCs470Rf8ewa4fltToJW1WpJCC6uCcIQUvmyr6LB9xVTU7EbcC9VOWEH9hYYrOsPQojiXCR5+n1zwbteVZNYXPTHilsVM+7/KFnTf4MPYU4CP6UUScCKoHM0swAv99YCknQOYkKHN6+C7PhEFcJ6lE6OJ1LD0+grvGtMVwYAQKBgQDL76KdEfbcbambQAxQTc5VBoZG4yaD4Zj8GOMz9k4A19/eR52WW3lFUl62MFarfN2Slyeyxt6YYWea6Hxs5xLnt7TLyhmgoyPZvToAYkmtfPlWHtHTDb7DGaRYXmL4ZY7IKF/bNok2ilgYOoKKt99hdrwgJeW3IT64eHqR46xYmwKBgQCwq++qo5Phx/aidQ6u+ygSonVwvxfmTYkBSM5cqzhrcbD7MVIOV+4OWjw12DPtXH/IV0OMyeaoDX0C4SfR++LYrhznJMoXd/K08F5Hv09aB4hOjvlq7T1EPLGAfG42ERrpKxh1KOa6Pxso1XRJz1U4GG0HrSlmJBAiq4Ag3GaBAQKBgAiSq1BVB/6eMYoQODRMAQd7/bsPI3hZzHeUiECP8xl/+a47bnl6oO90Ff0srQgKeLoH1qhiScs4FQXjDg/56saI53XFqiwhj4lAtiZ7+0LqxQSEySdJJaLH+iuo1BpDEqyBXf42HbCIQknKc+Bm+GH9fs0PKsf3As74aZamboFPAoGBAJp0BlhpH60hE2bd7ZNesZ7w9rk15yAJowBDdV4gtneAcph4euNdThqwGrl8JZGa73/ngn/AN22uNR9iVlzG2IBUX6JYUHGKBN7Y0aPqBeaQdUMwza8Eby6L3SaWIggUljFI4t3yfxxOdWESk9K/dyJOgGtYoLvSRWT6CE8yQE8BAoGAVI++9QpU5PuyiditGtSt5id7/ccT7Ms3YPNVDV63ayUYJ9CEMq3oXzH1fO9LVt89UE+HtALgDafySQ3rBUnbXw00kfPH3cWhARg66vVDIohoQAe8yIkhP55p8RBYLrcomIA3DP9yq0hvIYLAPZ0tKg6ktOM8ZBln2XlsYbkoGzo=,charset=utf-8,sellerId=2088102176904170,alipayPublicKey=MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxP5+1U3/0ovzQNb6tw2wDhoSwbohxKDI+/OdCsehDyMk7NWER07P37RLlAWRu0QhLUtseLna1+pfGLAo2BGHginHwZTxMHJnTq1sM4h0d4dAG7jbN1yTH/FMxYJ49WufK3112sEy4KUcmiChnlBsz0y7tNZnWYZJ/qsLM7gcbFBoYlvy/wM30MgIFtl8H7CQDHe4SJO1Eb7K0v2ilIhLRrc/GeKvHe7ZBmBmrrRaWZ3vHJUofFF4VKn961poeGmuYkuJqCz4AnhUlOKZhIjDdGncKsFU8rsWPIbx+QIbpq5h3Dssz2cG5ORcV8+drWGKYmgvyymKg8CWliLwVCObqQIDAQAB,
////    appId=2016092300577381,format=json,signType=RSA2,url=https://openapi.alipaydev.com/gateway.do
//    private HashMap createParamMap() {
//        HashMap paramMap = new HashMap();
//        paramMap.put("url", "https://openapi.alipaydev.com/gateway.do");
//        paramMap.put("appId", "2016092300577381");
//        paramMap.put("privateKey", "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCMvbfKQ4a6hVPibgw0ZVp0UEOZcYHPhvCKhgs3+u945ibNgjAA0fPFSpfjHyTq1ks5kCJMqEw68y9McXALZHvk2DVV5kp2ucwsYlQKVZ6PWTeq26k/Mzu5qmfrbgZjj/2vuYXuG41mFa0tRrk9RTDso5d2Z6UucEBq3YpwFlNe70I7AflK4LGo9p03aSEe4nLWIdJJGtsqrLX86WQGppMJc++mfcE7BEq+FqxVo+CrFOxH9RwDTccDe4pZIt/4Olq3y086AEPm+Wi2pqjvDTyfUjaSN8FwuZignSN4Qq7gapyAHLqNCRE0VigRq3bnJwj0mXkCdwJXMAtmZHw+FHObAgMBAAECggEAQmAHGcEW/Uh780HrR5q1Oj3QY8GAcxs0vl/RUqlp3x7MFgfcE8bwrI8tatP5WTePaqprQrPsn7CpEeg962GMfLTrEoP1gmDFxfjpoaYXjYuKEW5fN4s2E64mLIZLRRFXl1RrsYwU95wpfDzqh9bl5/SPLixbXrdZ6gxpics9rnt8xGCs470Rf8ewa4fltToJW1WpJCC6uCcIQUvmyr6LB9xVTU7EbcC9VOWEH9hYYrOsPQojiXCR5+n1zwbteVZNYXPTHilsVM+7/KFnTf4MPYU4CP6UUScCKoHM0swAv99YCknQOYkKHN6+C7PhEFcJ6lE6OJ1LD0+grvGtMVwYAQKBgQDL76KdEfbcbambQAxQTc5VBoZG4yaD4Zj8GOMz9k4A19/eR52WW3lFUl62MFarfN2Slyeyxt6YYWea6Hxs5xLnt7TLyhmgoyPZvToAYkmtfPlWHtHTDb7DGaRYXmL4ZY7IKF/bNok2ilgYOoKKt99hdrwgJeW3IT64eHqR46xYmwKBgQCwq++qo5Phx/aidQ6u+ygSonVwvxfmTYkBSM5cqzhrcbD7MVIOV+4OWjw12DPtXH/IV0OMyeaoDX0C4SfR++LYrhznJMoXd/K08F5Hv09aB4hOjvlq7T1EPLGAfG42ERrpKxh1KOa6Pxso1XRJz1U4GG0HrSlmJBAiq4Ag3GaBAQKBgAiSq1BVB/6eMYoQODRMAQd7/bsPI3hZzHeUiECP8xl/+a47bnl6oO90Ff0srQgKeLoH1qhiScs4FQXjDg/56saI53XFqiwhj4lAtiZ7+0LqxQSEySdJJaLH+iuo1BpDEqyBXf42HbCIQknKc+Bm+GH9fs0PKsf3As74aZamboFPAoGBAJp0BlhpH60hE2bd7ZNesZ7w9rk15yAJowBDdV4gtneAcph4euNdThqwGrl8JZGa73/ngn/AN22uNR9iVlzG2IBUX6JYUHGKBN7Y0aPqBeaQdUMwza8Eby6L3SaWIggUljFI4t3yfxxOdWESk9K/dyJOgGtYoLvSRWT6CE8yQE8BAoGAVI++9QpU5PuyiditGtSt5id7/ccT7Ms3YPNVDV63ayUYJ9CEMq3oXzH1fO9LVt89UE+HtALgDafySQ3rBUnbXw00kfPH3cWhARg66vVDIohoQAe8yIkhP55p8RBYLrcomIA3DP9yq0hvIYLAPZ0tKg6ktOM8ZBln2XlsYbkoGzo=");
//        paramMap.put("format", "json");
//        paramMap.put("charset", "utf-8");
//        paramMap.put("alipayPublicKey", "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxP5+1U3/0ovzQNb6tw2wDhoSwbohxKDI+/OdCsehDyMk7NWER07P37RLlAWRu0QhLUtseLna1+pfGLAo2BGHginHwZTxMHJnTq1sM4h0d4dAG7jbN1yTH/FMxYJ49WufK3112sEy4KUcmiChnlBsz0y7tNZnWYZJ/qsLM7gcbFBoYlvy/wM30MgIFtl8H7CQDHe4SJO1Eb7K0v2ilIhLRrc/GeKvHe7ZBmBmrrRaWZ3vHJUofFF4VKn961poeGmuYkuJqCz4AnhUlOKZhIjDdGncKsFU8rsWPIbx+QIbpq5h3Dssz2cG5ORcV8+drWGKYmgvyymKg8CWliLwVCObqQIDAQAB");
//        paramMap.put("signType", "RSA2");
//        paramMap.put("sellerId", "2088102176904170");
//        return paramMap;
//    }
//
//
//    @Rollback(false)
//    @Test
//    public void saveTest() throws Exception {
//
//        PaymentReq paymentReq = createPaymentReq();
//        paymentService.doPay(paymentReq);
//        System.out.println("11");
//    }
//
//    private PaymentReq createPaymentReq() {
//
//        PaymentReq paymentReq = PaymentReq.builder().clientName("熊成威").orderAmount(new BigDecimal(1000)).merchantId(merchantPayemtOrgAccount.getMerchant().getId()).paymentChannelCode(paymentChannelCode).build();
//        return paymentReq;
//    }
//
//
//}