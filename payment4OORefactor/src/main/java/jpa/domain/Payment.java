/*
 *    Copyright 2018-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package jpa.domain;

import io.swagger.annotations.ApiModelProperty;
import jpa.StrategyConverter;
import jpa.domain.status.PaymentStatus;
import jpa.domain.status.PaymentStatus4NonPayment;
import jpa.domain.status.PaymentStatus4Paying;
import jpa.repository.MerchantRepository;
import jpa.repository.PaymentChannelRepository;
import jpa.service.PaymentReq;
import lombok.*;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.math.BigDecimal;

import static jpa.bean.StrategyNumBean.getBeanByClass;
import static jpa.bean.StrategyNumBean.getBeanByClass4Context;

/**
 * @author pqq
 * @version v1.0
 * @date 2019年6月27日 10:00:00
 * @work 用户
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DISCRIMINATOR", discriminatorType = DiscriminatorType.STRING, length = 30)
public class Payment extends BaseEntity {

    /**
     * 返回代码
     */
    protected String rspCode;

    /**
     * 返回信息
     */
    @Column(length = 6553)
    protected String rspInfo;


    @ApiModelProperty(value = "订单编号")
    private String orderId;

    @ApiModelProperty(value = "客户号")
    private String clientId;

    @ApiModelProperty(value = "客户姓名")
    protected String clientName;

    @ApiModelProperty(value = "订单金额")
    private BigDecimal orderAmount;

//    @ApiModelProperty(value = "支付渠道编码:参考枚举对象:PaymentChannelCodeEnum")
//    private String paymentChannelCode;

    @ApiModelProperty(value = "商品的标题、交易标题、订单标题、订单关键字等")
    private String subject;

    @ApiModelProperty(value = "该笔订单允许的最晚付款时间、逾期将关闭交易，默认15d")
    private String timeoutExpress;

    @ApiModelProperty(value = "商品主类型：0—虚拟类商品，1—实物类商品")
    private String goodsType;

    @ApiModelProperty(value = "业务代码")
    private String businCode;

    @ApiModelProperty(value = "支付后返回url")
    private String returnUrl;

    @Convert(converter = StrategyConverter.class)
    protected PaymentStatus paymentStatus;

    @ManyToOne
    private PaymentChannel paymentChannel;
    @ManyToOne
    private Merchant merchant;

    public Payment(PaymentReq paymentReq) {
        BeanUtils.copyProperties(paymentReq, this);
        this.paymentChannel = getBeanByClass4Context(PaymentChannelRepository.class).findPaymentChannelByCode(paymentReq.getPaymentChannelCode());
        this.merchant = getBeanByClass4Context(MerchantRepository.class).findById(paymentReq.getMerchantId()).get();
        this.paymentStatus = getBeanByClass(PaymentStatus4NonPayment.class);

    }

    public void callPaying() {
        this.paymentStatus = getBeanByClass(PaymentStatus4Paying.class);

    }

}
