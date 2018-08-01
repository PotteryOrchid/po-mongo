package com.po.javaes.repo;

import com.po.javaes.doc.PhotoEs;
import com.po.javaes.vo.SearchByConditionReq;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ZJ on 06/07/2018.
 */
public interface PhotoEsRepo {

  boolean createIndex(String index, String type);

  boolean deleteIndex(String index);

  List<PhotoEs> searchByCondition(SearchByConditionReq req, String index);

}
