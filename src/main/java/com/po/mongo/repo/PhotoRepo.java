package com.po.mongo.repo;

import com.po.mongo.jpa.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ZJ on 19/07/2018.
 */
public interface PhotoRepo extends MongoRepository<Photo, String> {

  void deleteByPhoto(String pht);

}
