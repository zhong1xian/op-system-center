// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.asset.warehouse.service;

import com.only4play.common.constants.CodeEnum;
import com.only4play.common.exception.BusinessException;
import com.only4play.common.model.PageRequestWrapper;
import com.only4play.jpa.support.EntityOperations;
import com.only4play.system.domain.asset.warehouse.Warehouse;
import com.only4play.system.domain.asset.warehouse.creator.WarehouseCreator;
import com.only4play.system.domain.asset.warehouse.mapper.WarehouseMapper;
import com.only4play.system.domain.asset.warehouse.query.WarehouseQuery;
import com.only4play.system.domain.asset.warehouse.repository.WarehouseRepository;
import com.only4play.system.domain.asset.warehouse.updater.WarehouseUpdater;
import com.only4play.system.domain.asset.warehouse.vo.WarehouseVO;
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
public class WarehouseServiceImpl implements IWarehouseService {
  private final WarehouseRepository warehouseRepository;

  /**
   * createImpl
   */
  @Override
  public Long createWarehouse(WarehouseCreator creator) {
    Optional<Warehouse> warehouse = EntityOperations.doCreate(warehouseRepository)
    .create(() -> WarehouseMapper.INSTANCE.dtoToEntity(creator))
    .update(e -> e.init())
    .execute();
    return warehouse.isPresent() ? warehouse.get().getId() : 0;
  }

  /**
   * update
   */
  @Override
  public void updateWarehouse(WarehouseUpdater updater) {
    EntityOperations.doUpdate(warehouseRepository)
    .loadById(updater.getId())
    .update(e -> updater.updateWarehouse(e))
    .execute();
  }

  /**
   * valid
   */
  @Override
  public void validWarehouse(Long id) {
    EntityOperations.doUpdate(warehouseRepository)
    .loadById(id)
    .update(e -> e.valid())
    .execute();
  }

  /**
   * invalid
   */
  @Override
  public void invalidWarehouse(Long id) {
    EntityOperations.doUpdate(warehouseRepository)
    .loadById(id)
    .update(e -> e.invalid())
    .execute();
  }

  /**
   * findById
   */
  @Override
  public WarehouseVO findById(Long id) {
    Optional<Warehouse> warehouse =  warehouseRepository.findById(id);
    return new WarehouseVO(warehouse.orElseThrow(() -> new BusinessException(CodeEnum.NotFindError)));
  }

  /**
   * findByPage
   */
  @Override
  public Page<WarehouseVO> findByPage(PageRequestWrapper<WarehouseQuery> query) {
    BooleanBuilder booleanBuilder = new BooleanBuilder();
    Page<Warehouse> page = warehouseRepository.findAll(booleanBuilder,
            PageRequest.of(query.getPage() - 1, query.getPageSize(), Sort.by(
                Sort.Direction.DESC, "createdAt")));
    return new PageImpl<>(page.getContent().stream().map(entity -> new WarehouseVO(entity))
            .collect(Collectors.toList()), page.getPageable(), page.getTotalElements());
  }
}
