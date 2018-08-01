package com.po.javaes.exception;

/**
 * Created by ZJ on 05/07/2018.
 */
public class NodesEmptyException extends Exception {

  private String message;

  public NodesEmptyException() {
    super();
    this.message = getMsg();
  }

  private String getMsg() {
    return "The value of elasticsearch cluster nodes can not be empty.";
  }

}
