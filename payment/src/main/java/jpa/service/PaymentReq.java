package jpa.service;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: xiongchengwei
 * @Date: 2019/10/21 下午3:56
 */
@Builder
@Data
public class PaymentReq {

    @ApiModelProperty(value = "订单编号")
    private String orderId;

    @ApiModelProperty(value = "客户号")
    private String clientId;

    @ApiModelProperty(value = "商户号")
    private Long merchantId;

    @ApiModelProperty(value = "客户姓名")
    protected String clientName;

    @ApiModelProperty(value = "订单金额")
    private BigDecimal orderAmount;

    @ApiModelProperty(value = "支付渠道编码:参考枚举对象:PaymentChannelCodeEnum")
    private String paymentChannelCode;

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
}
