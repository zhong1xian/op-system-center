// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.asset.warehouse.service;

import com.only4play.common.model.PageRequestWrapper;
import com.only4play.system.domain.asset.warehouse.creator.WarehouseCreator;
import com.only4play.system.domain.asset.warehouse.query.WarehouseQuery;
import com.only4play.system.domain.asset.warehouse.updater.WarehouseUpdater;
import com.only4play.system.domain.asset.warehouse.vo.WarehouseVO;
import java.lang.Long;
import org.springframework.data.domain.Page;

public interface IWarehouseService {
  /**
   * create
   */
  Long createWarehouse(WarehouseCreator creator);

  /**
   * update
   */
  void updateWarehouse(WarehouseUpdater updater);

  /**
   * valid
   */
  void validWarehouse(Long id);

  /**
   * invalid
   */
  void invalidWarehouse(Long id);

  /**
   * findById
   */
  WarehouseVO findById(Long id);

  /**
   * findByPage
   */
  Page<WarehouseVO> findByPage(PageRequestWrapper<WarehouseQuery> query);
}