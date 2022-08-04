package com.only4play.system.domain.trade.order.domainservice;

import cn.hutool.core.util.IdUtil;
import com.only4play.jpa.support.EntityOperations;
import com.only4play.system.domain.trade.order.OrderBase;
import com.only4play.system.domain.trade.order.domainservice.model.OrderCompleteModel;
import com.only4play.system.domain.trade.order.domainservice.model.OrderCreateModel;
import com.only4play.system.domain.trade.order.domainservice.model.OrderReviseModel;
import com.only4play.system.domain.trade.order.mapper.OrderBaseMapper;
import com.only4play.system.domain.trade.order.repository.OrderBaseRepository;
import com.only4play.system.infrastructure.facade.IFlowNoFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderDomainServiceImpl implements IOrderDomainService{

  private final OrderBaseRepository orderBaseRepository;

  private final IFlowNoFacade flowNoFacade;

  @Override
  public boolean orderCreate(OrderCreateModel createModel) {
    Long flowNo = flowNoFacade.getNextId();
    OrderBase orderBase = OrderBaseMapper.INSTANCE.model2Entity(createModel);
    orderBase.setFlowNo(flowNo);
    EntityOperations
        .doCreate(orderBaseRepository)
        .create(() -> orderBase)
        .update(e -> e.init(createModel.getItemInfoList()))
        .execute();
    return true;
  }

  @Override
  public boolean orderRevise(OrderReviseModel reviseModel) {

    return true;
  }

  @Override
  public boolean orderComplete(OrderCompleteModel completeModel) {

    return true;
  }

  @Override
  public boolean orderCancel(Long flowNo) {
    return false;
  }
}
