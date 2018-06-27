package com.po.es.jpa;

import java.io.Serializable;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Created by ZJ on 26/06/2018.
 */
@Data
public class Address implements Serializable {

  @Field(type = FieldType.Keyword, store = true)
  private String code;

  @Field(type = FieldType.Text, analyzer = "standard", searchAnalyzer = "standard", store = true)
  private String msg;

}
