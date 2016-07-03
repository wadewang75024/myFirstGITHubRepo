package com.wwsoft.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

public class MyLoggerFactory implements LoggerFactory {

  /**
     The constructor should be public as it will be called by
     configurators in different packages.  */
  public MyLoggerFactory() {
	  System.out.println("****************** MyLoggerFactory.Constructor");
  }

  public Logger makeNewLoggerInstance(String name) {
	System.out.println("****************** MyLoggerFactory.makeNewLoggerInstance");
    return new MyLogger(name);
  }
}

