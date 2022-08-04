// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.user.request;

import com.only4play.common.model.Request;
import io.swagger.v3.oas.annotations.media.Schema;
import java.lang.Long;
import java.lang.String;

@Schema
public class UserBaseUpdateRequest implements Request {
  @Schema(
      title = "uuid"
  )
  private String uuid;

  @Schema(
      title = "phone"
  )
  private String phone;

  private Long id;

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
