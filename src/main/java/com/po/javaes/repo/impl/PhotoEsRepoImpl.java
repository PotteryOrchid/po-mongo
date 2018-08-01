package com.po.javaes.repo.impl;

import com.alibaba.fastjson.JSON;
import com.po.javaes.client.EsClient;
import com.po.javaes.doc.PhotoEs;
import com.po.javaes.repo.PhotoEsRepo;
import com.po.javaes.vo.SearchByConditionReq;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.stereotype.Service;

/**
 * Created by ZJ on 06/07/2018.
 */
@Service
public class PhotoEsRepoImpl implements PhotoEsRepo {

  @Override
  public boolean createIndex(String index, String type) {
    TransportClient client = null;
    client = new EsClient().getEsClient();

    IndicesExistsResponse indicesExistsResponse = client.admin().indices()
        .exists(new IndicesExistsRequest().indices(index)).actionGet();

    if (indicesExistsResponse.isExists()) {
      PutMappingResponse putMappingResponse = client.admin().indices().preparePutMapping(index)
          .setType(type).setSource(this.getIndexBuilder(type)).get();
      return putMappingResponse.isAcknowledged();
    } else {
      CreateIndexResponse createIndexResponse = client.admin().indices().prepareCreate(index)
          .addMapping(type, this.getIndexBuilder(type)).get();
      return createIndexResponse.isAcknowledged();
    }
  }

  @Override
  public boolean deleteIndex(String index) {
    TransportClient client = null;
    try {
      client = new EsClient().getEsClient();

      DeleteIndexResponse deleteIndexResponse = client.admin().indices().prepareDelete(index).get();

      return deleteIndexResponse.isAcknowledged();
    } catch (ElasticsearchException exception) {
      if (exception.status() == RestStatus.NOT_FOUND) {
        return true;
      }
    }
    return false;
  }

  @Override
  public List<PhotoEs> searchByCondition(SearchByConditionReq req, String index) {
    TransportClient client = null;

    List<PhotoEs> resLis = new LinkedList<>();

    if (req.getAlbumCoreIds().length <= 0) {
      return resLis;
    }
    client = new EsClient().getEsClient();

    int from = (req.getPageNo() - 1) * req.getPageSize();
    //System.out.println("==========4:" + System.currentTimeMillis());
    SearchResponse searchResponse = client.prepareSearch(index).setQuery(getSearchBuilder(req))
        .setFrom(from).setSize(req.getPageSize() == 0 ? 10 : req.getPageSize())
        .setTimeout(new TimeValue(60, TimeUnit.SECONDS)).get();
    //System.out.println("==========5:" + System.currentTimeMillis());
    SearchHits hits = searchResponse.getHits();
    if (null != hits) {
      SearchHit[] hits1 = hits.getHits();
      for (SearchHit s : hits1) {
        PhotoEs p = JSON.parseObject(s.getSourceAsString(), PhotoEs.class);
        p.setId(s.getId());
        resLis.add(p);
      }

      return resLis;
    }

    return resLis;
  }

  private BoolQueryBuilder getSearchBuilder(SearchByConditionReq req) {

    BoolQueryBuilder identity = null;
    if (null != req.getIdentity()) {
      if (null != req.getIdentity().getSfz() && !"".equals(req.getIdentity().getSfz())) {
        identity = QueryBuilders.boolQuery()
            .must(QueryBuilders.matchQuery("identity.sfz", req.getIdentity().getSfz())
                .analyzer("ik_max_word"));
      }

      if (null != req.getIdentity().getHz() && !"".equals(req.getIdentity().getHz())) {
        identity = QueryBuilders.boolQuery()
            .must(QueryBuilders.matchQuery("identity.hz", req.getIdentity().getHz()));
      }

      if (null != req.getIdentity().getJzz() && !"".equals(req.getIdentity().getJzz())) {
        identity = QueryBuilders.boolQuery()
            .must(QueryBuilders.matchQuery("identity.jzz", req.getIdentity().getJzz()));
      }

      if (null != req.getIdentity().getQz() && !"".equals(req.getIdentity().getQz())) {
        identity = QueryBuilders.boolQuery()
            .must(QueryBuilders.matchQuery("identity.qz", req.getIdentity().getQz()));
      }

      if (null != req.getIdentity().getGatxz() && !"".equals(req.getIdentity().getGatxz())) {
        identity = QueryBuilders.boolQuery()
            .must(QueryBuilders.matchQuery("identity.gatxz", req.getIdentity().getGatxz()));
      }

      if (null != req.getIdentity().getTwtxz() && !"".equals(req.getIdentity().getTwtxz())) {
        identity = QueryBuilders.boolQuery()
            .must(QueryBuilders.matchQuery("identity.twtxz", req.getIdentity().getTwtxz()));
      }

      if (null != req.getIdentity().getHkb() && !"".equals(req.getIdentity().getHkb())) {
        identity = QueryBuilders.boolQuery()
            .must(QueryBuilders.matchQuery("identity.hkb", req.getIdentity().getHkb()));
      }

      if (null != req.getIdentity().getJgz() && !"".equals(req.getIdentity().getJgz())) {
        identity = QueryBuilders.boolQuery()
            .must(QueryBuilders.matchQuery("identity.jgz", req.getIdentity().getJgz()));
      }

      if (null != req.getIdentity().getTbz() && !"".equals(req.getIdentity().getTbz())) {
        identity = QueryBuilders.boolQuery()
            .must(QueryBuilders.matchQuery("identity.tbz", req.getIdentity().getTbz()));
      }

      if (null != req.getIdentity().getJcz() && !"".equals(req.getIdentity().getJcz())) {
        identity = QueryBuilders.boolQuery()
            .must(QueryBuilders.matchQuery("identity.jcz", req.getIdentity().getJcz()));
      }

      if (null != req.getIdentity().getOther() && !"".equals(req.getIdentity().getOther())) {
        identity = QueryBuilders.boolQuery()
            .must(QueryBuilders.matchQuery("identity.other", req.getIdentity().getOther()));
      }
    }

    BoolQueryBuilder cmnt = null;
    if (null != req.getCmnt() && !"".equals(req.getCmnt())) {
      cmnt = QueryBuilders.boolQuery()
          .must(QueryBuilders.matchQuery("cmnt", req.getCmnt()).analyzer("ik_max_word"));
    }

    BoolQueryBuilder name = null;
    if (null != req.getName() && !"".equals(req.getName())) {
      name = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("name", req.getName()));
    }

    BoolQueryBuilder albums = null;
    if (req.getAlbumCoreIds().length > 0) {
      albums = QueryBuilders.boolQuery()
          .filter(QueryBuilders.termsQuery("album_core_id", req.getAlbumCoreIds()));
    }

    BoolQueryBuilder gender = null;
    if (null != req.getGender()) {
      gender = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("gender", req.getGender()));
    }

    BoolQueryBuilder nation = null;
    if (null != req.getNation() && null != req.getNation().getCode()) {
      nation = QueryBuilders.boolQuery()
          .must(QueryBuilders.matchQuery("nation.code", req.getNation().getCode()));
    }

    BoolQueryBuilder addr = null;
    if (null != req.getAddr() && null != req.getAddr().getMsg() && !""
        .equals(req.getAddr().getMsg())) {
      addr = QueryBuilders.boolQuery()
          .must(QueryBuilders.matchQuery("addr.msg", req.getAddr().getMsg()));
    }

    BoolQueryBuilder res = QueryBuilders.boolQuery();
    if (null != identity) {
      res.must(identity);
    }
    if (null != cmnt) {
      res.must(cmnt);
    }
    if (null != albums) {
      res.must(albums);
    }
    if (null != name) {
      res.must(name);
    }
    if (null != addr) {
      res.must(addr);
    }
    if (null != nation) {
      res.must(nation);
    }
    if (null != name) {
      res.must(name);
    }
    if (null != gender) {
      res.must(gender);
    }

    return res;
  }

  private XContentBuilder getIndexBuilder(String type) {
    try {
      XContentBuilder builder = XContentFactory.jsonBuilder();

      builder.startObject();
      {
        builder.startObject(type);
        {
          builder.startObject("properties");
          {
            /* addr */
            builder.startObject("addr");
            {
              builder.startObject("properties");
              {
                builder.startObject("code");
                {
                  builder.field("type", "text");
                  builder.field("store", false);
                  builder.field("index", false);
                }
                builder.endObject();
                builder.startObject("msg");
                {
                  builder.field("type", "text");
                  builder.field("analyzer", "standard");
                }
                builder.endObject();
              }
              builder.endObject();
            }
            builder.endObject();

            /* cmnt */
            builder.startObject("cmnt");
            {
              builder.field("type", "text");
              builder.field("analyzer", "ik_max_word");
            }
            builder.endObject();

            /* gender */
            builder.startObject("gender");
            {
              builder.field("type", "integer");
            }
            builder.endObject();

            /* id */
            builder.startObject("id");
            {
              builder.field("type", "keyword");
            }
            builder.endObject();

            /* identity */
            builder.startObject("identity");
            {
              builder.startObject("properties");
              {
                builder.startObject("gatxz");
                {
                  builder.field("type", "text");
                  builder.field("analyzer", "standard");
                }
                builder.endObject();

                builder.startObject("hkb");
                {
                  builder.field("type", "text");
                  builder.field("analyzer", "standard");
                }
                builder.endObject();

                builder.startObject("hz");
                {
                  builder.field("type", "text");
                  builder.field("analyzer", "standard");
                }
                builder.endObject();

                builder.startObject("jcz");
                {
                  builder.field("type", "text");
                  builder.field("analyzer", "standard");
                }
                builder.endObject();

                builder.startObject("jgz");
                {
                  builder.field("type", "text");
                  builder.field("analyzer", "standard");
                }
                builder.endObject();

                builder.startObject("jzz");
                {
                  builder.field("type", "text");
                  builder.field("analyzer", "standard");
                }
                builder.endObject();

                builder.startObject("other");
                {
                  builder.field("type", "text");
                  builder.field("analyzer", "standard");
                }
                builder.endObject();

                builder.startObject("qz");
                {
                  builder.field("type", "text");
                  builder.field("analyzer", "standard");
                }
                builder.endObject();

                builder.startObject("sfz");
                {
                  builder.field("type", "text");
                  builder.field("analyzer", "ik_max_word");
                }
                builder.endObject();

                builder.startObject("tbz");
                {
                  builder.field("type", "text");
                  builder.field("analyzer", "standard");
                }
                builder.endObject();

                builder.startObject("twtxz");
                {
                  builder.field("type", "text");
                  builder.field("analyzer", "standard");
                }
                builder.endObject();

              }
              builder.endObject();
            }
            builder.endObject();

            /* name */
            builder.startObject("name");
            {
              builder.field("type", "text");
              builder.field("analyzer", "standard");
            }
            builder.endObject();

            /* album_core_id */
            builder.startObject("album_core_id");
            {
              builder.field("type", "keyword");
            }
            builder.endObject();

            /* core_id */
            builder.startObject("core_id");
            {
              builder.field("type", "keyword");
            }
            builder.endObject();

            /* face_id */
            builder.startObject("face_id");
            {
              builder.field("type", "keyword");
            }
            builder.endObject();

            /* url */
            builder.startObject("url");
            {
              builder.field("type", "text");
              builder.field("store", false);
              builder.field("index", false);
            }
            builder.endObject();

            /* nation */
            builder.startObject("nation");
            {
              builder.startObject("properties");
              {
                builder.startObject("code");
                {
                  builder.field("type", "integer");
                }
                builder.endObject();
                builder.startObject("msg");
                {
                  builder.field("type", "text");
                  builder.field("store", false);
                  builder.field("index", false);
                }
                builder.endObject();
              }
              builder.endObject();
            }
            builder.endObject();

            /* birthday */
            builder.startObject("birthday");
            {
              builder.field("type", "text");
              builder.field("store", false);
              builder.field("index", false);
            }
            builder.endObject();

            /* src */
            builder.startObject("src");
            {
              builder.field("type", "text");
              builder.field("analyzer", "standard");
            }
            builder.endObject();

            /* st */
            builder.startObject("st");
            {
              builder.field("type", "text");
              builder.field("index", false);
              builder.field("store", false);
            }
            builder.endObject();

            /* flag */
            builder.startObject("flag");
            {
              builder.field("type", "integer");
              builder.field("index", false);
              builder.field("store", false);
            }
            builder.endObject();

            /* photo_src */
            builder.startObject("photo_src");
            {
              builder.startObject("properties");
              {
                builder.startObject("type");
                {
                  builder.field("type", "integer");
                  builder.field("index", false);
                  builder.field("store", false);
                }
                builder.endObject();
                builder.startObject("name");
                {
                  builder.field("type", "text");
                  builder.field("index", false);
                  builder.field("store", false);
                }
                builder.endObject();
                builder.startObject("cmt_id");
                {
                  builder.field("type", "text");
                  builder.field("index", false);
                  builder.field("store", false);
                }
                builder.endObject();
                builder.startObject("cmt_name");
                {
                  builder.field("type", "text");
                  builder.field("index", false);
                  builder.field("store", false);
                }
                builder.endObject();
              }
              builder.endObject();
            }
            builder.endObject();

            /* create_time */
            builder.startObject("create_time");
            {
              builder.field("type", "long");
              builder.field("index", false);
              builder.field("store", false);
            }
            builder.endObject();

            /* modify_time */
            builder.startObject("modify_time");
            {
              builder.field("type", "long");
              builder.field("index", false);
              builder.field("store", false);
            }
            builder.endObject();

          }
          builder.endObject();
        }
        builder.endObject();
      }
      builder.endObject();
      return builder;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

}
