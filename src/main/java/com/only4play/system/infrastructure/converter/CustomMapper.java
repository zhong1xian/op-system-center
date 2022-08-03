package com.only4play.system.infrastructure.converter;


import com.only4play.system.domain.objectsku.SkuType;
import com.only4play.system.domain.template.selectdict.DictType;
import com.only4play.system.domain.template.templateitem.InputType;

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

}
