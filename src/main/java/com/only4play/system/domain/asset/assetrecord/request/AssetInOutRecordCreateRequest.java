// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.asset.assetrecord.request;

import com.only4play.common.model.Request;
import com.only4play.system.domain.asset.assetrecord.InOutBizType;
import com.only4play.system.domain.asset.assetrecord.InOutType;
import io.swagger.v3.oas.annotations.media.Schema;
import java.lang.String;

@Schema
public class AssetInOutRecordCreateRequest implements Request {
  @Schema(
      title = "批次号"
  )
  private String batchNo;

  @Schema(
      title = "出入库业务类型"
  )
  private InOutBizType inOutBizType;

  @Schema(
      title = "操作人"
  )
  private String operateUser;

  @Schema(
      title = "出入类型"
  )
  private InOutType inOutType;

  public String getBatchNo() {
    return batchNo;
  }

  public void setBatchNo(String batchNo) {
    this.batchNo = batchNo;
  }

  public InOutBizType getInOutBizType() {
    return inOutBizType;
  }

  public void setInOutBizType(InOutBizType inOutBizType) {
    this.inOutBizType = inOutBizType;
  }

  public String getOperateUser() {
    return operateUser;
  }

  public void setOperateUser(String operateUser) {
    this.operateUser = operateUser;
  }

  public InOutType getInOutType() {
    return inOutType;
  }

  public void setInOutType(InOutType inOutType) {
    this.inOutType = inOutType;
  }
}