package com.po.es.repo;

import com.po.es.jpa.PhotoES;
import java.util.List;

/**
 * Created by ZJ on 28/06/2018.
 */
public interface PhotoESRepoTemp {

  List<PhotoES> findByName(String name);

  List<PhotoES> findBySfz(String sfz);

  String savePhotoES(PhotoES photoES);

}
