// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.asset.asset.service;

import com.only4play.common.model.PageRequestWrapper;
import com.only4play.system.domain.asset.asset.query.AssetQuery;
import com.only4play.system.domain.asset.asset.vo.AssetVO;
import java.lang.Long;
import org.springframework.data.domain.Page;

public interface IAssetService {

  /**
   * findById
   */
  AssetVO findById(Long id);

  /**
   * findByPage
   */
  Page<AssetVO> findByPage(PageRequestWrapper<AssetQuery> query);
}