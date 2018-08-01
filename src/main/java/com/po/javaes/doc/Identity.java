package com.po.javaes.doc;


import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import lombok.Data;

/**
 * Created by ZJ on 06/07/2018.
 */
@Data
public class Identity implements Serializable {

  @JSONField(name = "sfz")
  private String sfz;

  @JSONField(name = "hz")
  private String hz;

  @JSONField(name = "jzz")
  private String jzz;

  @JSONField(name = "qz")
  private String qz;

  @JSONField(name = "gatxz")
  private String gatxz;

  @JSONField(name = "twtxz")
  private String twtxz;

  @JSONField(name = "hkb")
  private String hkb;

  @JSONField(name = "jgz")
  private String jgz;

  @JSONField(name = "tbz")
  private String tbz;

  @JSONField(name = "jcz")
  private String jcz;

  @JSONField(name = "other")
  private String other;

}
