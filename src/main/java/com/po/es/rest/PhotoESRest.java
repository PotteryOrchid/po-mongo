package com.po.es.rest;

import com.po.es.jpa.PhotoES;
import com.po.es.service.PhotoESService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZJ on 26/06/2018.
 */

@RestController
@RequestMapping("/v1/es/photo")
public class PhotoESRest {

  @Autowired
  private PhotoESService photoESService;

  @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<PhotoES> findByName(@PathVariable("name") String name) {
    return photoESService.findByName(name);
  }

//  @POST
//  public void insert(PhotoES photoES) {
//    photoESService.insert(photoES);
//  }

}
