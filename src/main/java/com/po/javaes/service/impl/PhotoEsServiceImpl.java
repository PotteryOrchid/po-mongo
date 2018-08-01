package com.po.javaes.service.impl;

import com.po.javaes.doc.PhotoEs;
import com.po.javaes.repo.PhotoEsRepo;
import com.po.javaes.service.PhotoEsService;
import com.po.javaes.vo.SearchByConditionReq;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZJ on 06/07/2018.
 */
@Service
public class PhotoEsServiceImpl implements PhotoEsService {

  @Autowired
  PhotoEsRepo photoEsRepo;

  @Override
  public boolean createIndex(String index, String type) {
    return photoEsRepo.createIndex(index, type);
  }

  @Override
  public boolean deleteIndex(String index) {
    return photoEsRepo.deleteIndex(index);
  }

  @Override
  public List<PhotoEs> searchByCondition(SearchByConditionReq req, String index) {
    //System.out.println("==========3:" + System.currentTimeMillis());
    return photoEsRepo.searchByCondition(req, index);
  }
}
