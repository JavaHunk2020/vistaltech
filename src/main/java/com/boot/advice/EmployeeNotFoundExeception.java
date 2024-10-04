package com.boot.advice;

public class EmployeeNotFoundExeception extends RuntimeException {
	
  public EmployeeNotFoundExeception(String message) {
	  super(message);
  }
}
