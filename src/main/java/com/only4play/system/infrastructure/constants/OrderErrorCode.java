package com.only4play.system.infrastructure.constants;

import com.only4play.common.constants.BaseEnum;
import java.util.Optional;

public enum OrderErrorCode implements BaseEnum<OrderErrorCode> {

  PAY_TOO_BIG(11010001, "支付的金额过大");

  OrderErrorCode(Integer code, String name) {
    this.code = code;
    this.name = name;
  }

  private Integer code;
  private String name;

  @Override
  public Integer getCode() {
    return this.code;
  }

  @Override
  public String getName() {
    return this.name;
  }

  public static Optional<OrderErrorCode> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(OrderErrorCode.class, code));
  }

}
