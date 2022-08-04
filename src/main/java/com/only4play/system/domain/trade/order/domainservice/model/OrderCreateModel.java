package com.only4play.system.domain.trade.order.domainservice.model;

import com.only4play.common.annotation.FieldDesc;
import com.only4play.order.commons.pay.PayItem;
import com.only4play.system.domain.trade.order.OrderType;
import com.only4play.system.domain.user.AccountType;
import com.only4play.system.infrastructure.model.CodeValue;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * 订单创建模型
 */
@Data
public class OrderCreateModel {

  @NotNull(message = "订单金额不能为空")
  @FieldDesc(name = "订单金额")
  private BigDecimal totalAmount;

  @FieldDesc(name = "账号Id")
  private Long accountId;

  @FieldDesc(name = "账号类型")
  private AccountType accountType;

  @FieldDesc(name = "订单类型、订单类型创建不同的状态机")
  private OrderType orderType;

  @FieldDesc(name = "支付详情")
  private List<PayItem> payList;

  @FieldDesc(name = "订单属性信息")
  private List<CodeValue> attrs;

  @FieldDesc(name = "订单项列表")
  private List<OrderItemModel> itemInfoList;


}
