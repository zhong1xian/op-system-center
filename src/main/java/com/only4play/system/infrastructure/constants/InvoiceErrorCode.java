package com.only4play.system.infrastructure.constants;

import com.only4play.common.constants.BaseEnum;
import java.util.Optional;

public enum InvoiceErrorCode implements BaseEnum<InvoiceErrorCode> {

  xxxx(1201000, "name");

  InvoiceErrorCode(Integer code, String name) {
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

  public static Optional<InvoiceErrorCode> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(InvoiceErrorCode.class, code));
  }

}