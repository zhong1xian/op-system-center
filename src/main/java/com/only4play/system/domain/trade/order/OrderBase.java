package com.only4play.system.domain.trade.order;

import cn.hutool.core.util.NumberUtil;
import com.only4play.codegen.processor.api.GenCreateRequest;
import com.only4play.codegen.processor.api.GenQueryRequest;
import com.only4play.codegen.processor.api.GenResponse;
import com.only4play.codegen.processor.api.GenUpdateRequest;
import com.only4play.codegen.processor.controller.GenController;
import com.only4play.codegen.processor.creator.GenCreator;
import com.only4play.codegen.processor.mapper.GenMapper;
import com.only4play.codegen.processor.query.GenQuery;
import com.only4play.codegen.processor.query.QueryItem;
import com.only4play.codegen.processor.repository.GenRepository;
import com.only4play.codegen.processor.service.GenService;
import com.only4play.codegen.processor.creator.IgnoreCreator;
import com.only4play.codegen.processor.updater.IgnoreUpdater;
import com.only4play.codegen.processor.service.GenServiceImpl;
import com.only4play.codegen.processor.updater.GenUpdater;
import com.only4play.codegen.processor.vo.GenVo;
import com.only4play.common.annotation.FieldDesc;
import com.only4play.common.annotation.TypeConverter;
import com.only4play.common.constants.ValidStatus;
import com.only4play.jpa.converter.ValidStatusConverter;
import com.only4play.jpa.support.BaseJpaAggregate;
import com.only4play.order.commons.pay.PayItem;
import com.only4play.system.infrastructure.converter.CodeValueListConverter;
import com.only4play.system.infrastructure.converter.PayItemListConverter;
import com.only4play.system.infrastructure.model.CodeValue;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

@GenVo(pkgName = "com.only4play.system.domain.trade.order.vo")
@GenCreator(pkgName = "com.only4play.system.domain.trade.order.creator")
@GenUpdater(pkgName = "com.only4play.system.domain.trade.order.updater")
@GenRepository(pkgName = "com.only4play.system.domain.trade.order.repository")
@GenService(pkgName = "com.only4play.system.domain.trade.order.service")
@GenServiceImpl(pkgName = "com.only4play.system.domain.trade.order.service")
@GenQuery(pkgName = "com.only4play.system.domain.trade.order.query")
@GenMapper(pkgName = "com.only4play.system.domain.trade.order.mapper")
@GenController(pkgName = "com.only4play.system.controller")
@GenCreateRequest(pkgName = "com.only4play.system.domain.trade.order.request")
@GenUpdateRequest(pkgName = "com.only4play.system.domain.trade.order.request")
@GenQueryRequest(pkgName = "com.only4play.system.domain.trade.order.request")
@GenResponse(pkgName = "com.only4play.system.domain.trade.order.response")
@Entity
@Table(name = "order_base")
@Data
public class OrderBase extends BaseJpaAggregate {

  @FieldDesc(name = "唯一流水号")
  @IgnoreUpdater
  private Long flowNo;

  @NotNull(message = "订单金额不能为空")
  @FieldDesc(name = "订单金额")
  private BigDecimal totalAmount;

  @NotNull(message = "订单真实金额不能为空")
  @FieldDesc(name = "真实金额")
  private BigDecimal realAmount;

  @NotNull(message = "用户Id不能为空")
  @QueryItem
  @FieldDesc(name = "用户id")
  private Long userId;

  @FieldDesc(name = "订单类型、订单类型创建不同的状态机")
  @Convert(converter = OrderTypeConverter.class)
  @TypeConverter(toTypeFullName = "java.lang.Integer")
  @IgnoreUpdater
  @QueryItem
  private OrderType orderType;

  @FieldDesc(name = "支付详情")
  @IgnoreCreator
  @IgnoreUpdater
  @Convert(converter = PayItemListConverter.class)
  @Column(columnDefinition = "text")
  private List<PayItem> payList;

  @IgnoreCreator
  @IgnoreUpdater
  @FieldDesc(name = "支付时间")
  private Long payTime;

  @FieldDesc(name = "订单状态")
  @Convert(converter = OrderStateConverter.class)
  @IgnoreCreator
  @IgnoreUpdater
  @TypeConverter(toTypeFullName = "java.lang.Integer")
  private OrderState orderState;

  @Convert(converter = ValidStatusConverter.class)
  @IgnoreUpdater
  @IgnoreCreator
  private ValidStatus validStatus;

  @FieldDesc(name = "订单信息")
  @Convert(converter = CodeValueListConverter.class)
  private List<CodeValue> attrs;
  /**
   * 初始化订单
   */
//  public void initOrder(OrderCreateRequest request) {
////    setFlowNo(WaterFlowUtils.nextWaterFlow());
////    setValidStatus(ValidStatus.VALID);
////    setTotalAmount(NumberUtil.add(request.getTotalAmount()));
////    setOrderType(OrderType.of(request.getOrderType()).orElseThrow(() -> new BusinessException(
////        OrderErrorCode.ORDER_TYPE_ILLEGAL)));
////    if(Objects.isNull(request.getPayList())){
////      setPayList(Collections.EMPTY_LIST);
////    }else {
////      setPayList(request.getPayList());
////    }
////    setOrderState(getInitStateByOrderType(getOrderType(),request.getRealAmount()));
////    registerEvent(new OrderCreateEvent(this,request.getOrderItems()));
//  }

  public void init(){}

  /**
   * 根据订单类型获取初始状态
   * @param orderType
   * @return
   */
  private OrderState getInitStateByOrderType(OrderType orderType,BigDecimal realMoney){
    if(NumberUtil.equals(realMoney,BigDecimal.ZERO)){
      return OrderState.PAY_SUCCESS;
    }
    return OrderState.WAIT_PAY;
  }

  public void valid(){
    setValidStatus(ValidStatus.VALID);
  }

  public void invalid(){
    setValidStatus(ValidStatus.INVALID);
  }
}
