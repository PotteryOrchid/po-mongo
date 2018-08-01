package com.po.javaes.client;

import com.po.javaes.config.EsConfig;
import com.po.javaes.exception.NodesEmptyException;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

/**
 * Created by ZJ on 05/07/2018.
 */
public class EsClient {

  private static TransportClient client;

  static {
    if (EsConfig.getClusterNodes() == null || "".equals(EsConfig.getClusterNodes())) {
      try {
        throw new NodesEmptyException();
      } catch (NodesEmptyException e) {
        e.printStackTrace();
      }
    }

    Settings settings = Settings.builder()
        .put("client.transport.sniff", true)
        .put("cluster.name", EsConfig.getClusterName())
        .put("client.transport.ping_timeout", "30s")
        .put("client.transport.nodes_sampler_interval", "10s")
        .build();

    client = new PreBuiltTransportClient(settings)
        .addTransportAddresses(EsConfig.getEsAdresses());
  }

  public final TransportClient getEsClient() {
    return EsClient.client;
  }

  public void closeEsClient(TransportClient transportClient) {
    if (null != transportClient) {
      transportClient.close();
    }
  }

}
