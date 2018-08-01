package com.po.javaes.doc;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import lombok.Data;

/**
 * Created by ZJ on 06/07/2018.
 */
@Data
public class Nation implements Serializable {

  @JSONField(name = "code")
  private Integer code;

  @JSONField(name = "msg")
  private String msg;

}
