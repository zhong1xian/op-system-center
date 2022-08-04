package com.only4play.system.domain.trade.order;

import com.only4play.common.annotation.FieldDesc;
import com.only4play.order.commons.pay.PayItem;
import com.only4play.system.domain.trade.orderitem.OrderItem;
import com.only4play.system.infrastructure.model.CodeValue;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "order_index")
@Data
public class OrderDocument {

  private String id;

  @FieldDesc(name = "订单类型")
  private Integer orderType;

  @FieldDesc(name = "订单类型文字显示")
  private String orderTypeTxt;

  private String flowNo;

  private BigDecimal totalAmount;

  private BigDecimal realAmount;

  private String orderStatusTxt;

  private Integer orderStatus;

  @FieldDesc(name = "用户ID")
  private Long userId;

  @Field(type = FieldType.Nested)
  private List<CodeValue> orderAttr;

  @Field(type = FieldType.Nested)
  private List<PayItem> payItems;

  @Field(type = FieldType.Nested)
  private List<OrderItem> orderItems;

  private Long payTime;

  //其他用户的信息，渠道的统计信息等

}
