package com.only4play.system.infrastructure.constants;


import com.only4play.common.constants.BaseEnum;
import java.util.Optional;

public enum AssetErrorCode implements BaseEnum<AssetErrorCode> {

    ASSETS_HAS_IN(10000026,"商品已经入库"),
    ASSETS_HAS_OUT(10000027,"商品已经出库")
    ;

  AssetErrorCode(Integer code, String name) {
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

  public static Optional<AssetErrorCode> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(AssetErrorCode.class, code));
  }

}