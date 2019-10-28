package jpa.service;

import jpa.domain.Payment;
import jpa.dto.DeployCommandReqDto;
import jpa.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static jpa.bean.StrategyNumBean.getClassyByClassAndNumber;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/21 下午3:56
 */
@Service
public class paymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public void doPay(PaymentReq paymentReq) {
        Payment payment = createPayment(paymentReq);


        paymentRepository.save(payment);
        payment.getPaymentChannel().getPaymentStrategy().executePay(payment);
        paymentRepository.save(payment);

    }


    private Payment createPayment(PaymentReq paymentReq) {
        String type = paymentReq.getPaymentChannelCode();
        Payment payment = null;
        try {
            Class childClass = getClassyByClassAndNumber(Payment.class, type);
            Constructor constructor = childClass.getConstructor(paymentReq.getClass());
            payment = (Payment) constructor.newInstance(paymentReq);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return payment;
    }

}
