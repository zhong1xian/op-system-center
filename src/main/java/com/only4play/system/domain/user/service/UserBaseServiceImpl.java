// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.user.service;

import com.only4play.common.constants.CodeEnum;
import com.only4play.common.exception.BusinessException;
import com.only4play.common.model.PageRequestWrapper;
import com.only4play.jpa.support.EntityOperations;
import com.only4play.system.domain.user.UserBase;
import com.only4play.system.domain.user.creator.UserBaseCreator;
import com.only4play.system.domain.user.mapper.UserBaseMapper;
import com.only4play.system.domain.user.query.UserBaseQuery;
import com.only4play.system.domain.user.repository.UserBaseRepository;
import com.only4play.system.domain.user.updater.UserBaseUpdater;
import com.only4play.system.domain.user.vo.UserBaseVO;
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
public class UserBaseServiceImpl implements IUserBaseService {
  private final UserBaseRepository userBaseRepository;

  /**
   * createImpl
   */
  @Override
  public Long createUserBase(UserBaseCreator creator) {
    Optional<UserBase> userBase = EntityOperations.doCreate(userBaseRepository)
    .create(() -> UserBaseMapper.INSTANCE.dtoToEntity(creator))
    .update(e -> e.init())
    .execute();
    return userBase.isPresent() ? userBase.get().getId() : 0;
  }

  /**
   * update
   */
  @Override
  public void updateUserBase(UserBaseUpdater updater) {
    EntityOperations.doUpdate(userBaseRepository)
    .loadById(updater.getId())
    .update(e -> updater.updateUserBase(e))
    .execute();
  }

  /**
   * valid
   */
  @Override
  public void validUserBase(Long id) {
    EntityOperations.doUpdate(userBaseRepository)
    .loadById(id)
    .update(e -> e.valid())
    .execute();
  }

  /**
   * invalid
   */
  @Override
  public void invalidUserBase(Long id) {
    EntityOperations.doUpdate(userBaseRepository)
    .loadById(id)
    .update(e -> e.invalid())
    .execute();
  }

  /**
   * findById
   */
  @Override
  public UserBaseVO findById(Long id) {
    Optional<UserBase> userBase =  userBaseRepository.findById(id);
    return new UserBaseVO(userBase.orElseThrow(() -> new BusinessException(CodeEnum.NotFindError)));
  }

  /**
   * findByPage
   */
  @Override
  public Page<UserBaseVO> findByPage(PageRequestWrapper<UserBaseQuery> query) {
    BooleanBuilder booleanBuilder = new BooleanBuilder();
    Page<UserBase> page = userBaseRepository.findAll(booleanBuilder,
            PageRequest.of(query.getPage() - 1, query.getPageSize(), Sort.by(
                Sort.Direction.DESC, "createdAt")));
    return new PageImpl<>(page.getContent().stream().map(entity -> new UserBaseVO(entity))
            .collect(Collectors.toList()), page.getPageable(), page.getTotalElements());
  }
}
