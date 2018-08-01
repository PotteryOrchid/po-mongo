package com.po.javaes.exception;

/**
 * Created by ZJ on 05/07/2018.
 */
public class NodesInvaildException extends Exception {

  private String message;

  public NodesInvaildException(String message) {
    super(message);
    this.message = getMsg(message);
  }

  private String getMsg(String message) {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(
        "The elasticsearch cluster nodes address does not conform to syntax requirements(ip:port,ip:host), please checkout your input ' ");
    stringBuffer.append(message);
    stringBuffer.append(" '");
    return stringBuffer.toString();
  }

}
