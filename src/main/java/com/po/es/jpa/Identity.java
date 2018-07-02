package com.po.es.jpa;

import java.io.Serializable;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Created by ZJ on 26/06/2018.
 */
@Data
public class Identity implements Serializable {

  @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word", store = true)
  private String sfz;

  @Field(type = FieldType.Text, analyzer = "standard", searchAnalyzer = "standard", store = true)
  private String hz;

  @Field(type = FieldType.Text, analyzer = "standard", searchAnalyzer = "standard", store = true)
  private String jzz;

  @Field(type = FieldType.Text, analyzer = "standard", searchAnalyzer = "standard", store = true)
  private String qz;

  @Field(type = FieldType.Text, analyzer = "standard", searchAnalyzer = "standard", store = true)
  private String gatxz;

  @Field(type = FieldType.Text, analyzer = "standard", searchAnalyzer = "standard", store = true)
  private String twtxz;

  @Field(type = FieldType.Text, analyzer = "standard", searchAnalyzer = "standard", store = true)
  private String hkb;

  @Field(type = FieldType.Text, analyzer = "standard", searchAnalyzer = "standard", store = true)
  private String jgz;

  @Field(type = FieldType.Text, analyzer = "standard", searchAnalyzer = "standard", store = true)
  private String tbz;

  @Field(type = FieldType.Text, analyzer = "standard", searchAnalyzer = "standard", store = true)
  private String jcz;

  @Field(type = FieldType.Text, analyzer = "standard", searchAnalyzer = "standard", store = true)
  private String other;
}
