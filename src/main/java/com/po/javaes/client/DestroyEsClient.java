package com.po.javaes.client;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

/**
 * Created by ZJ on 01/08/2018.
 *
 * run before spring application shutdown.
 */
@Component
public class DestroyEsClient implements DisposableBean, ExitCodeGenerator {

  @Override
  public void destroy() throws Exception {
    EsClient client = new EsClient();
    client.closeEsClient(client.getEsClient());
  }

  @Override
  public int getExitCode() {
    return 5;
  }
}
