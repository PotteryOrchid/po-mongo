package com.po.mongo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by ZJ on 08/03/2018.
 */
@Component
public class BucketInitRunner implements ApplicationRunner {

  @Autowired
  BucketInfo bucketInfo;

  @Override
  public void run(ApplicationArguments applicationArguments) throws Exception {
    // 判断所有Bucket是否都创建成功
    while (!BucketInfo.hasAllBuckets()) {
      bucketInfo.createAllBuckets();
      Thread.sleep(15000);
    }
  }
}
