package com.po.es.jpa;

import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Created by ZJ on 26/06/2018.
 */
@Document(indexName = "photo_test")
@Data
public class PhotoES implements Serializable {

  @Id
  @Field(type = FieldType.Keyword, index = false, store = true)
  private String id;

  @Field(type = FieldType.Text, analyzer = "standard", searchAnalyzer = "standard", store = true)
  private String name;

  @Field(type = FieldType.Object)
  private Identity identity;

  @Field(type = FieldType.Integer, store = true)
  private Integer gender;

  @Field(type = FieldType.Object)
  private Address addr;

  @Field(type = FieldType.Text, analyzer = "standard", searchAnalyzer = "standard", store = true)
  private String cmnt;
}
