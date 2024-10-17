package com.boot.advice;

public class ResourceNotFoundExeception extends RuntimeException {
	
  public ResourceNotFoundExeception(String message) {
	  super(message);
  }
}
