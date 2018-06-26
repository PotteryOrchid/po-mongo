package com.po.es.service.impl;

import com.po.es.jpa.PhotoES;
import com.po.es.repo.PhotoESRepo;
import com.po.es.service.PhotoESService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZJ on 26/06/2018.
 */
@Service
public class PhotoESServiceImpl implements PhotoESService {

  @Autowired
  private PhotoESRepo photoESRepo;

  @Override
  public List<PhotoES> findByName(String name) {
    return photoESRepo.findByName(name);
  }
}
