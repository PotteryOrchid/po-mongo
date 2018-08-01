package com.po.javaes.sched;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by ZJ on 20/07/2018.
 */
@Slf4j
@Component
public class PhotoSchedule {

  /**
   * 每六分钟调用一次，每次删除1万数据，一天可删除240万数据
   */
  @Scheduled(cron = "0 0/6 * * * ?")
  public void deletePhotoByAlbum() {

  }

}
