package jpa.domain;

import jpa.domain.status.PaymentStatus;
import jpa.domain.status.PaymentStatus4Fail;
import jpa.domain.status.PaymentStatus4NonPayment;
import jpa.domain.status.PaymentStatus4Paying;
import jpa.repository.MerchantRepository;
import jpa.repository.PaymentChannelRepository;
import jpa.service.PaymentReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

import static jpa.bean.StrategyNumBean.getBeanByClass;
import static jpa.bean.StrategyNumBean.getBeanByClass4Context;
import static jpa.util.MoneyUtil.string2BigDecimal;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/21 下午3:10
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@DiscriminatorValue("payment4Alipay")
public class Payment4Alipay extends Payment {

    private static final int ORDER_LENGTH_LIMIT = 64;
    private static final BigDecimal LEFT_AMOUNT = string2BigDecimal("0.01");
    private static final BigDecimal RIGHT_AMOUNT = string2BigDecimal("100000000");
    private static final String[] GOODS_TYPES = {"0", "1"};

    private String alipaySubject;

    private String alipayTimeoutExpress;

    private String alipayGoodsType;

    private String alipaySyncMessage;

    private String alipayAsyncMessage;

    private String alipayTradeStatus;

    private String alipayOurResponse;

    private String alipayTradeCloseMessage;

    private String alipayTradeQueryMessage;


    public Payment4Alipay(PaymentReq paymentReq) {
        super(paymentReq);

    }

    public void callPrepaymentSucc(String syncResponseBody) {
        this.rspInfo = syncResponseBody;
        this.paymentStatus = new PaymentStatus4Paying();
    }

    public void callPrepaymentFail(String syncResponseBody) {
        this.rspInfo = syncResponseBody;
        this.paymentStatus = new PaymentStatus4Fail();
    }

}
