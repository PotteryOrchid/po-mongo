package com.po.es.rest;

import com.po.es.jpa.PhotoES;
import com.po.es.service.PhotoESService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZJ on 26/06/2018.
 */

@RestController
@RequestMapping("/v5/es/photo")
public class PhotoESRest {

  @Autowired
  private PhotoESService photoESService;

  @RequestMapping(value = "/name", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<PhotoES> findByName(@RequestParam("name") String name) {
    return photoESService.findByName(name);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public PhotoES insert(PhotoES photoES) {
    return photoESService.savePhoto(photoES);
  }

  @GetMapping("/info")
  public String getInfo() {
    return "hello";
  }

}
