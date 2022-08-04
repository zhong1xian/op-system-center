// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.trade.orderlifecycle.service;

import com.only4play.common.constants.CodeEnum;
import com.only4play.common.exception.BusinessException;
import com.only4play.common.model.PageRequestWrapper;
import com.only4play.jpa.support.EntityOperations;
import com.only4play.system.domain.trade.orderlifecycle.OrderLifecycle;
import com.only4play.system.domain.trade.orderlifecycle.creator.OrderLifecycleCreator;
import com.only4play.system.domain.trade.orderlifecycle.mapper.OrderLifecycleMapper;
import com.only4play.system.domain.trade.orderlifecycle.query.OrderLifecycleQuery;
import com.only4play.system.domain.trade.orderlifecycle.repository.OrderLifecycleRepository;
import com.only4play.system.domain.trade.orderlifecycle.updater.OrderLifecycleUpdater;
import com.only4play.system.domain.trade.orderlifecycle.vo.OrderLifecycleVO;
import com.querydsl.core.BooleanBuilder;
import java.lang.Long;
import java.lang.Override;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@Slf4j
@RequiredArgsConstructor
public class OrderLifecycleServiceImpl implements IOrderLifecycleService {
  private final OrderLifecycleRepository orderLifecycleRepository;

  /**
   * createImpl
   */
  @Override
  public Long createOrderLifecycle(OrderLifecycleCreator creator) {
    Optional<OrderLifecycle> orderLifecycle = EntityOperations.doCreate(orderLifecycleRepository)
    .create(() -> OrderLifecycleMapper.INSTANCE.dtoToEntity(creator))
    .update(e -> e.init())
    .execute();
    return orderLifecycle.isPresent() ? orderLifecycle.get().getId() : 0;
  }

  /**
   * update
   */
  @Override
  public void updateOrderLifecycle(OrderLifecycleUpdater updater) {
    EntityOperations.doUpdate(orderLifecycleRepository)
    .loadById(updater.getId())
    .update(e -> updater.updateOrderLifecycle(e))
    .execute();
  }

  /**
   * valid
   */
  @Override
  public void validOrderLifecycle(Long id) {
    EntityOperations.doUpdate(orderLifecycleRepository)
    .loadById(id)
    .update(e -> e.valid())
    .execute();
  }

  /**
   * invalid
   */
  @Override
  public void invalidOrderLifecycle(Long id) {
    EntityOperations.doUpdate(orderLifecycleRepository)
    .loadById(id)
    .update(e -> e.invalid())
    .execute();
  }

  /**
   * findById
   */
  @Override
  public OrderLifecycleVO findById(Long id) {
    Optional<OrderLifecycle> orderLifecycle =  orderLifecycleRepository.findById(id);
    return new OrderLifecycleVO(orderLifecycle.orElseThrow(() -> new BusinessException(CodeEnum.NotFindError)));
  }

  /**
   * findByPage
   */
  @Override
  public Page<OrderLifecycleVO> findByPage(PageRequestWrapper<OrderLifecycleQuery> query) {
    BooleanBuilder booleanBuilder = new BooleanBuilder();
    Page<OrderLifecycle> page = orderLifecycleRepository.findAll(booleanBuilder,
            PageRequest.of(query.getPage() - 1, query.getPageSize(), Sort.by(
                Sort.Direction.DESC, "createdAt")));
    return new PageImpl<>(page.getContent().stream().map(entity -> new OrderLifecycleVO(entity))
            .collect(Collectors.toList()), page.getPageable(), page.getTotalElements());
  }
}