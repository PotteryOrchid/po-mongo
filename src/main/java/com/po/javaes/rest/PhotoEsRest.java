package com.po.javaes.rest;

import com.po.javaes.config.EsConfig;
import com.po.javaes.doc.PhotoEs;
import com.po.javaes.service.PhotoEsService;
import com.po.javaes.vo.SearchByConditionReq;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZJ on 06/07/2018.
 */
@RestController
@RequestMapping(value = {"/api/picture/v5/photo"})
public class PhotoEsRest {

  @Autowired
  PhotoEsService photoEsService;


  @PutMapping("/es/index/{index}/{type}")
  String createIndex(@PathVariable String index, @PathVariable String type) {
    return photoEsService.createIndex(index, type) ? "OK" : "ERROR";
  }

  @DeleteMapping("/es/index/{index}")
  String deleteIndex(@PathVariable String index) {
    return photoEsService.deleteIndex(index) ? "OK" : "ERROR";
  }

  @PostMapping("/search/findByCondition")
  List<PhotoEs> searchByCondition(@RequestBody SearchByConditionReq req) {
    return photoEsService.searchByCondition(req, EsConfig.getIndex());
  }


}
