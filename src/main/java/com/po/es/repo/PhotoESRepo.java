package com.po.es.repo;

import com.po.es.jpa.PhotoES;
import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by ZJ on 26/06/2018.
 */
public interface PhotoESRepo extends ElasticsearchRepository<PhotoES, String> {

  List<PhotoES> findByName(String name);

}
