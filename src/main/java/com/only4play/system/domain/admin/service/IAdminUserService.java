// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.admin.service;

import com.only4play.common.model.PageRequestWrapper;
import com.only4play.system.domain.admin.creator.AdminUserCreator;
import com.only4play.system.domain.admin.query.AdminUserQuery;
import com.only4play.system.domain.admin.updater.AdminUserUpdater;
import com.only4play.system.domain.admin.vo.AdminUserVO;
import java.lang.Long;
import org.springframework.data.domain.Page;

public interface IAdminUserService {
  /**
   * create
   */
  Long createAdminUser(AdminUserCreator creator);

  /**
   * update
   */
  void updateAdminUser(AdminUserUpdater updater);

  /**
   * valid
   */
  void validAdminUser(Long id);

  /**
   * invalid
   */
  void invalidAdminUser(Long id);

  /**
   * findById
   */
  AdminUserVO findById(Long id);

  /**
   * findByPage
   */
  Page<AdminUserVO> findByPage(PageRequestWrapper<AdminUserQuery> query);
}