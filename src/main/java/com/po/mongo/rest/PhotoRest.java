package com.po.mongo.rest;

import com.po.mongo.jpa.Photo;
import com.po.mongo.repo.PhotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZJ on 19/07/2018.
 */
@RestController
@RequestMapping("/v5/mongo/photo")
public class PhotoRest {

  @Autowired
  PhotoRepo photoRepo;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public Photo insertPhoto(@RequestBody Photo photo) {
    return photoRepo.insert(photo);
  }

  @DeleteMapping(value = "/name/{pht}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void delPhoto(@PathVariable String pht) {
    photoRepo.deleteByPhoto(pht);
  }

}
