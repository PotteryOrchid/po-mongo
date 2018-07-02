package com.po.es.service.impl;

import com.po.es.jpa.PhotoES;
import com.po.es.repo.PhotoESRepo;
import com.po.es.service.PhotoESService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
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

  @Override
  public List<PhotoES> findBySfz(String sfz) {
//    MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("identity.sfz", sfz);
//    Iterator<PhotoES> iterator = photoESRepo.search(queryBuilder).iterator();
//    List<PhotoES> list = new ArrayList<>();
//
//    while (iterator.hasNext()) {
//      list.add(iterator.next());
//    }

    return photoESRepo.findBySfz(sfz);
  }

  @Override
  public String savePhoto(PhotoES photoES) {
    return photoESRepo.savePhotoES(photoES);
  }
}
