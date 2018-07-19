package com.po.mongo.jpa;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by ZJ on 04/06/2018.
 */
@Data
@Document(collection = "photo")
public class Photo {

  @Id
  private String id;

  @Field("photo")
  private String photo;

}
