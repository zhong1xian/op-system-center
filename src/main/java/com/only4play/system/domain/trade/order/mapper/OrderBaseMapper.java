// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.trade.order.mapper;

import com.only4play.common.mapper.DateMapper;
import com.only4play.common.mapper.GenericEnumMapper;
import com.only4play.system.domain.trade.order.OrderBase;
import com.only4play.system.domain.trade.order.creator.OrderBaseCreator;
import com.only4play.system.domain.trade.order.domainservice.model.OrderCreateModel;
import com.only4play.system.domain.trade.order.query.OrderBaseQuery;
import com.only4play.system.domain.trade.order.request.OrderBaseCreateRequest;
import com.only4play.system.domain.trade.order.request.OrderBaseQueryRequest;
import com.only4play.system.domain.trade.order.request.OrderBaseUpdateRequest;
import com.only4play.system.domain.trade.order.response.OrderBaseResponse;
import com.only4play.system.domain.trade.order.updater.OrderBaseUpdater;
import com.only4play.system.domain.trade.order.vo.OrderBaseVO;
import com.only4play.system.infrastructure.converter.CustomMapper;
import com.only4play.system.infrastructure.elastic.OrderDocument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(
    uses = {
        GenericEnumMapper.class,
        DateMapper.class,
        CustomMapper.class
    }
)
public interface OrderBaseMapper {
  OrderBaseMapper INSTANCE = Mappers.getMapper(OrderBaseMapper.class);

  OrderBase dtoToEntity(OrderBaseCreator dto);

  OrderBaseUpdater request2Updater(OrderBaseUpdateRequest request);

  OrderBaseCreator request2Dto(OrderBaseCreateRequest request);

  OrderBaseQuery request2Query(OrderBaseQueryRequest request);

  OrderBaseResponse vo2Response(OrderBaseVO vo);

  OrderDocument entity2Document(OrderBase entity);

  OrderBase model2Entity(OrderCreateModel createModel);

  default OrderBaseResponse vo2CustomResponse(OrderBaseVO vo) {
    OrderBaseResponse response = vo2Response(vo);
    return response;
  }
}
