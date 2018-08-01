package com.po.javaes.doc;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import lombok.Data;

/**
 * Created by ZJ on 06/07/2018.
 */
@Data
public class PhotoSrc implements Serializable {

  @JSONField(name = "type")
  private Integer type;

  @JSONField(name = "name")
  private String name;

  @JSONField(name = "cmtId")
  private String cmtId;

  @JSONField(name = "cmtName")
  private String cmtName;

}
