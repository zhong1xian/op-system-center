package com.only4play.system.domain.asset.asset.events;

import com.only4play.system.domain.asset.asset.Asset;
import com.only4play.system.domain.asset.asset.domainservice.model.AssetBizInfo;
import com.only4play.system.domain.asset.assetlifecycle.creator.AssetLifecycleCreator;
import com.only4play.system.domain.asset.assetlifecycle.service.IAssetLifecycleService;
import com.only4play.system.domain.asset.assetrecord.service.IAssetInOutRecordService;
import com.only4play.system.domain.asset.warehouse.service.IWarehouseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
public class AssetEventProcessor {

    private final IAssetLifecycleService assetLifecycleService;

    private final IWarehouseService warehouseService;

    private final IAssetInOutRecordService assetInOutRecordService;

    @EventListener
    public void handleAssetInForLifecycle(AssetEvents.AssetInEvent inEvent){
        AssetBizInfo bizInfo = inEvent.getBizInfo();
        Asset asset = inEvent.getAsset();
        /**
         * 艺术性的处理采用批号的方式进行批量插入操作，避免每次事件都插入一条记录，这样有性能问题
         */
        List<AssetLifecycleCreator> assetLifecycleCreators = bizInfo.getUniqueCodes().stream()
                .map(code -> {
                    AssetLifecycleCreator creator = new AssetLifecycleCreator();
                    creator.setAssetsId(asset.getId());
                    creator.setHouseId(asset.getHouseId());
                    creator.setName(asset.getName());
                    creator.setHouseName(warehouseService.findById(asset.getHouseId()).getName());
                    creator.setInOutBizType(bizInfo.getInOutBizType());
                    creator.setUniqueCode(code);
                    return creator;
                }).collect(Collectors.toList());
        assetLifecycleService.batchCreateLifecycle(bizInfo.getGenBatchNo(), assetLifecycleCreators);
    }

    @EventListener
    public void handleAssetOutForLifecycle(AssetEvents.AssetOutEvent outEvent){

    }

    /**
     * 出入库记录
     * @param outEvent
     */
    @EventListener
    public void handleAssetOutForRecord(AssetEvents.AssetOutEvent outEvent){

    }

    @EventListener
    public void handleAssetInForRecord(AssetEvents.AssetInEvent inEvent){

    }
}
