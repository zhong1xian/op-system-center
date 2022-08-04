package com.only4play.system.domain.trade.orderitem;

import com.only4play.codegen.processor.api.GenCreateRequest;
import com.only4play.codegen.processor.api.GenQueryRequest;
import com.only4play.codegen.processor.api.GenResponse;
import com.only4play.codegen.processor.api.GenUpdateRequest;
import com.only4play.codegen.processor.controller.GenController;
import com.only4play.codegen.processor.creator.GenCreator;
import com.only4play.codegen.processor.mapper.GenMapper;
import com.only4play.codegen.processor.query.GenQuery;
import com.only4play.codegen.processor.repository.GenRepository;
import com.only4play.codegen.processor.service.GenService;
import com.only4play.codegen.processor.creator.IgnoreCreator;
import com.only4play.codegen.processor.updater.IgnoreUpdater;
import com.only4play.codegen.processor.service.GenServiceImpl;
import com.only4play.codegen.processor.updater.GenUpdater;
import com.only4play.codegen.processor.vo.GenVo;
import com.only4play.common.annotation.FieldDesc;
import com.only4play.common.constants.ValidStatus;
import com.only4play.jpa.converter.ValidStatusConverter;
import com.only4play.jpa.support.BaseJpaAggregate;
import java.math.BigDecimal;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@GenVo(pkgName = "com.only4play.system.domain.trade.orderitem.vo")
@GenCreator(pkgName = "com.only4play.system.domain.trade.orderitem.creator")
@GenUpdater(pkgName = "com.only4play.system.domain.trade.orderitem.updater")
@GenRepository(pkgName = "com.only4play.system.domain.trade.orderitem.repository")
@GenService(pkgName = "com.only4play.system.domain.trade.orderitem.service")
@GenServiceImpl(pkgName = "com.only4play.system.domain.trade.orderitem.service")
@GenQuery(pkgName = "com.only4play.system.domain.trade.orderitem.query")
@GenMapper(pkgName = "com.only4play.system.domain.trade.orderitem.mapper")
@GenController(pkgName = "com.only4play.system.controller")
@GenCreateRequest(pkgName = "com.only4play.system.domain.trade.orderitem.request")
@GenUpdateRequest(pkgName = "com.only4play.system.domain.trade.orderitem.request")
@GenQueryRequest(pkgName = "com.only4play.system.domain.trade.orderitem.request")
@GenResponse(pkgName = "com.only4play.system.domain.trade.orderitem.response")
@Entity
@Table(name = "order_item")
@Data
public class OrderItem extends BaseJpaAggregate {

  @FieldDesc(name = "唯一流水号")
  private Long flowNo;

  private BigDecimal amount;

  @FieldDesc(name = "真实金额")
  private BigDecimal realAmount;

  @FieldDesc(name = "计量数量")
  private BigDecimal itemCount;

  @FieldDesc(name = "计量单位")
  private String measureUnit;

  @FieldDesc(name = "商品ID/计费模型ID")
  private String goodsId;

  @FieldDesc(name = "商品编码")
  private String goodsCode;

  @FieldDesc(name = "商品名称")
  private String goodsName;

  @FieldDesc(name = "费用描述")
  private String feeRemark;

  @Convert(converter = ValidStatusConverter.class)
  @IgnoreUpdater
  @IgnoreCreator
  private ValidStatus validStatus;

  public void init() {
    setValidStatus(ValidStatus.VALID);
  }

  public void valid(){
    setValidStatus(ValidStatus.VALID);
  }

  public void invalid(){
    setValidStatus(ValidStatus.INVALID);
  }
}