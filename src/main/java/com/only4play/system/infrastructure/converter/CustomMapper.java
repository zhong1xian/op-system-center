package com.only4play.system.infrastructure.converter;


import com.only4play.system.domain.template.selectdict.DictType;
import com.only4play.system.domain.template.templateitem.InputType;

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


}
