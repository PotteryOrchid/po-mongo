package com.po.javaes.vo;

import com.po.javaes.doc.Address;
import com.po.javaes.doc.Identity;
import lombok.Data;

/**
 * Created by ZJ on 07/07/2018.
 */
@Data
public class SearchByConditionReq {

  private Integer pageNo;

  private Integer pageSize;

  private String[] albumCoreIds;

  private String name;

  private NationReq nation;

  private Address addr;

  private Integer gender;

  private Identity identity;

  private String cmnt;

}
