package com.only4play.system.infrastructure.converter;


import com.only4play.system.domain.objectsku.SkuType;
import com.only4play.system.domain.template.selectdict.DictType;
import com.only4play.system.domain.template.templateitem.InputType;
import com.only4play.system.domain.trade.order.OrderState;
import com.only4play.system.domain.trade.order.OrderType;
import com.only4play.system.domain.trade.orderlifecycle.OrderOperateType;
import com.only4play.system.domain.user.AccountType;

/**
 * 枚举自定义转化
 * 在实体类中的枚举都要进行配置
 */
public class CustomMapper {

  public Integer type2Int(InputType type) {
    return type.getCode();
  }

  public InputType int2Type(Integer code) {
    return InputType.of(code).orElse(InputType.TEXT);
  }

  public Integer dictType2Int(DictType dictType) {
    return dictType.getCode();
  }

  public DictType int2DictType(Integer code) {
    return DictType.of(code).orElse(DictType.SELECT_LIST);
  }
  public Integer skuType2Int(SkuType skuType){
    return skuType.getCode();
  }

  public SkuType int2SkuType(Integer code){
    return SkuType.of(code).orElse(SkuType.SINGLE);
  }

  public Integer orderType2Int(OrderType orderType){
    return orderType.getCode();
  }

  public OrderType int2OrderType(Integer code){
    return OrderType.of(code).orElse(OrderType.CHARGE);
  }

  public Integer accountType2Int(AccountType accountType){
    return accountType.getCode();
  }

  public AccountType int2AccountType(Integer code){
    return AccountType.of(code).orElse(AccountType.PERSONAL);
  }


  public Integer opType2Int(OrderOperateType type){
    return type.getCode();
  }

  public OrderOperateType int2OpType(Integer code){
    return OrderOperateType.of(code).orElse(OrderOperateType.AUTH_SUCCESS);
  }

  public Integer status2OrderState(OrderState state){
    return state.getCode();
  }

  public OrderState state2Int(Integer code){
    return OrderState.of(code).orElse(OrderState.WAIT_PAY);
  }


}
