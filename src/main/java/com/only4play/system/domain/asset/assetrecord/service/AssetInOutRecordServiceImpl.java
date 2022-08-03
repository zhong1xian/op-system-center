// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.asset.assetrecord.service;

import com.only4play.common.constants.CodeEnum;
import com.only4play.common.exception.BusinessException;
import com.only4play.common.model.PageRequestWrapper;
import com.only4play.jpa.support.EntityOperations;
import com.only4play.system.domain.asset.assetrecord.AssetInOutRecord;
import com.only4play.system.domain.asset.assetrecord.creator.AssetInOutRecordCreator;
import com.only4play.system.domain.asset.assetrecord.mapper.AssetInOutRecordMapper;
import com.only4play.system.domain.asset.assetrecord.query.AssetInOutRecordQuery;
import com.only4play.system.domain.asset.assetrecord.repository.AssetInOutRecordRepository;
import com.only4play.system.domain.asset.assetrecord.updater.AssetInOutRecordUpdater;
import com.only4play.system.domain.asset.assetrecord.vo.AssetInOutRecordVO;
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
public class AssetInOutRecordServiceImpl implements IAssetInOutRecordService {
  private final AssetInOutRecordRepository assetInOutRecordRepository;

  /**
   * createImpl
   */
  @Override
  public Long createAssetInOutRecord(AssetInOutRecordCreator creator) {
    Optional<AssetInOutRecord> assetInOutRecord = EntityOperations.doCreate(assetInOutRecordRepository)
    .create(() -> AssetInOutRecordMapper.INSTANCE.dtoToEntity(creator))
    .update(e -> e.init())
    .execute();
    return assetInOutRecord.isPresent() ? assetInOutRecord.get().getId() : 0;
  }

  /**
   * update
   */
  @Override
  public void updateAssetInOutRecord(AssetInOutRecordUpdater updater) {
    EntityOperations.doUpdate(assetInOutRecordRepository)
    .loadById(updater.getId())
    .update(e -> updater.updateAssetInOutRecord(e))
    .execute();
  }

  /**
   * valid
   */
  @Override
  public void validAssetInOutRecord(Long id) {
    EntityOperations.doUpdate(assetInOutRecordRepository)
    .loadById(id)
    .update(e -> e.valid())
    .execute();
  }

  /**
   * invalid
   */
  @Override
  public void invalidAssetInOutRecord(Long id) {
    EntityOperations.doUpdate(assetInOutRecordRepository)
    .loadById(id)
    .update(e -> e.invalid())
    .execute();
  }

  /**
   * findById
   */
  @Override
  public AssetInOutRecordVO findById(Long id) {
    Optional<AssetInOutRecord> assetInOutRecord =  assetInOutRecordRepository.findById(id);
    return new AssetInOutRecordVO(assetInOutRecord.orElseThrow(() -> new BusinessException(CodeEnum.NotFindError)));
  }

  /**
   * findByPage
   */
  @Override
  public Page<AssetInOutRecordVO> findByPage(PageRequestWrapper<AssetInOutRecordQuery> query) {
    BooleanBuilder booleanBuilder = new BooleanBuilder();
    Page<AssetInOutRecord> page = assetInOutRecordRepository.findAll(booleanBuilder,
            PageRequest.of(query.getPage() - 1, query.getPageSize(), Sort.by(
                Sort.Direction.DESC, "createdAt")));
    return new PageImpl<>(page.getContent().stream().map(entity -> new AssetInOutRecordVO(entity))
            .collect(Collectors.toList()), page.getPageable(), page.getTotalElements());
  }
}
