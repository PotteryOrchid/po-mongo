package com.po.javaes.config;

import com.po.javaes.exception.NodesInvaildException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ZJ on 05/07/2018.
 */
@Component
public class EsConfig {

  private static String clusterName;

  private static String clusterNodes;

  private static String index;

  @Value("${elasticsearch.cluster.name:elasticsearch}")
  private void setClusterName(String clusterName) {
    EsConfig.clusterName = clusterName;
  }

  @Value("${elasticsearch.cluster.nodes:127.0.0.1:9300}")
  private void setClusterNodes(String clusterNodes) {
    EsConfig.clusterNodes = clusterNodes;
  }

  @Value("${elasticsearch.cluster.index:photo_index}")
  private void setIndex(String index) {
    EsConfig.index = index;
  }

  public static String getClusterName() {
    return EsConfig.clusterName;
  }

  public static String getClusterNodes() {
    return EsConfig.clusterNodes;
  }

  public static String getIndex() {
    return EsConfig.index;
  }

  public static InetSocketTransportAddress[] getEsAdresses() {
    try {
      return EsConfig.getTransportAddresses();
    } catch (NodesInvaildException e) {
      e.printStackTrace();
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
    return null;
  }

  private static InetSocketTransportAddress[] getTransportAddresses()
      throws NodesInvaildException, UnknownHostException {
    List<InetSocketTransportAddress> transportAddressList = new ArrayList<>();
    String[] addrs = EsConfig.getClusterNodes().split(",");
    for (String addr : addrs) {
      if (addr.contains(":") && addr.split(":").length == 2) {
        String[] strs = addr.split(":");
        InetSocketTransportAddress transportAddress = new InetSocketTransportAddress(
            InetAddress.getByName(strs[0]),
            Integer.parseInt(strs[1]));
        transportAddressList.add(transportAddress);
      } else {
        throw new NodesInvaildException(EsConfig.getClusterNodes());
      }
    }
    InetSocketTransportAddress[] res = new InetSocketTransportAddress[transportAddressList.size()];
    return transportAddressList.toArray(res);
  }

}
