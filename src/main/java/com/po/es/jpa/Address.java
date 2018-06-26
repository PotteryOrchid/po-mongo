package com.po.es.jpa;


import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Created by ZJ on 26/06/2018.
 */
public class Address {

  @Field(type = FieldType.Keyword, store = true)
  private String code;

  @Field(type = FieldType.Text, analyzer = "ik", searchAnalyzer = "ik", store = true)
  private String msg;

}
