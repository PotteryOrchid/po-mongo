package com.po.es.repo.impl;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

import com.po.es.jpa.PhotoES;
import com.po.es.repo.PhotoESRepoTemp;
import java.util.List;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

/**
 * Created by ZJ on 28/06/2018.
 */
public class PhotoESRepoImpl implements PhotoESRepoTemp {

  @Autowired
  ElasticsearchTemplate elasticsearchTemplate;

  @Override
  public List<PhotoES> findByName(String name) {
    // condition
    BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
    boolQueryBuilder.must(QueryBuilders.matchQuery("name", name));
    // search query
    SearchQuery searchQuery = new NativeSearchQueryBuilder()
        .withQuery(matchAllQuery()).withQuery(boolQueryBuilder).build();

    return elasticsearchTemplate.queryForList(searchQuery, PhotoES.class);
  }

  @Override
  public List<PhotoES> findBySfz(String sfz) {
    // condition
    BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
    boolQueryBuilder.must(QueryBuilders.matchQuery("identity.sfz", sfz));
    // search query
    SearchQuery searchQuery = new NativeSearchQueryBuilder()
        .withQuery(matchAllQuery()).withQuery(boolQueryBuilder).build();

    return elasticsearchTemplate.queryForList(searchQuery, PhotoES.class);
  }

  @Override
  public String savePhotoES(PhotoES photoES) {
    IndexQuery indexQuery = new IndexQueryBuilder()
        .withId(photoES.getId())
        .withIndexName("photo_test").withObject(photoES)
        .withType("photoes").build();

    return elasticsearchTemplate.index(indexQuery);
  }
}
