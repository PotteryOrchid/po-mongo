package com.po.es.service;

import com.po.es.jpa.PhotoES;
import java.util.List;

/**
 * Created by ZJ on 26/06/2018.
 */
public interface PhotoESService {

  List<PhotoES> findByName(String name);

  PhotoES savePhoto(PhotoES photoES);

}
