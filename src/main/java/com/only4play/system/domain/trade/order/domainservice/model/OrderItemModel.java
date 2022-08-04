package com.only4play.system.domain.trade.order.domainservice.model;

import com.only4play.common.annotation.FieldDesc;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OrderItemModel {

  @FieldDesc(name = "真实金额")
  private BigDecimal realAmount;

  @FieldDesc(name = "计量数量")
  private BigDecimal itemCount;

  @FieldDesc(name = "skuId")
  private String skuId;

  @FieldDesc(name = "商品名称")
  private String goodsName;

  @FieldDesc(name = "费用描述")
  private String feeRemark;

}
