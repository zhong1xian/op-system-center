package com.only4play.system.domain.trade.order.events;

import com.only4play.system.domain.trade.order.domainservice.model.OrderItemModel;
import com.only4play.system.domain.trade.order.events.OrderEvents.OrderCancelEvent;
import com.only4play.system.domain.trade.order.events.OrderEvents.OrderCreateEvent;
import com.only4play.system.domain.trade.orderitem.service.IOrderItemService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderEventProcessor {

  private final IOrderItemService orderItemService;

  @EventListener
  public void handleOrderCreateForEs(OrderCreateEvent orderCreateEvent){

  }

  @EventListener
  public void handleOrderCancelForEs(OrderCancelEvent orderCancelEvent){

  }

  @EventListener
  public void handleOrderCreateForItem(OrderCreateEvent orderCreateEvent){

    List<OrderItemModel> itemInfoList = orderCreateEvent.getCreateModel().getItemInfoList();
  }



}
