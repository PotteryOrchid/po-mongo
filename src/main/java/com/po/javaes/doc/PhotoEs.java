package com.po.javaes.doc;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.ToString;

/**
 * Created by ZJ on 06/07/2018.
 */
@Data
@ToString
@XmlRootElement
public class PhotoEs implements Serializable {

  private String id;

  @JSONField(name = "albumCoreId")
  private String albumCoreId;

  private String albumName;

  @JSONField(name = "coreId")
  private String coreId;

  @JSONField(name = "faceId")
  private String faceId;

  @JSONField(name = "url")
  private String url;

  @JSONField(name = "name")
  private String name;

  @JSONField(name = "nation")
  private Nation nation;

  @JSONField(name = "birthday")
  private String birthday;

  @JSONField(name = "addr")
  private Address addr;

  /**
   * 1：男性; 2：女性; 3：未知;
   */
  @JSONField(name = "gender")
  private Integer gender;

  @JSONField(name = "identity")
  private Identity identity;

  @JSONField(name = "src")
  private String src;

  @JSONField(name = "st")
  private String st;

  @JSONField(name = "cmnt")
  private String cmnt;

  /**
   * -1：强制入库；
   */
  @JSONField(name = "flag")
  private Integer flag;

  @JSONField(name = "photoSrc")
  private PhotoSrc photoSrc;

  @JSONField(name = "createTime")
  private Long createTime;

  @JSONField(name = "modifyTime")
  private Long modifyTime;

}
