package com.wwsoft.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.Level;
import com.wwsoft.logger.XLevel;

public class MyLogger extends Logger {

  // It's usually a good idea to add a dot suffix to the fully
  // qualified class name. This makes caller localization to work
  // properly even from classes that have almost the same fully
  // qualified class name as MyLogger, e.g. MyLoggerTest.
  static String FQCN = MyLogger.class.getName() + ".";

  // It's enough to instantiate a factory once and for all.
  private static MyLoggerFactory myFactory = new MyLoggerFactory();

  /**
     Just calls the parent constuctor.
   */
  public MyLogger(String name) {
    super(name);
  }

  /**
     Overrides the standard debug method by appending " wwsoft" at the
     end of each message.  */
  public 
  void debug(Object message) {
    super.log(FQCN, Level.DEBUG, "****************** " + message , null);    
  }
  
  /**
  Overrides the standard debug method by appending " wwsoft" at the
  end of each message.  */
  public 
  void error(Object message) {
	  super.log(FQCN, Level.ERROR, "****************** " + message , null);    
  }

  /**
     This method overrides {@link Logger#getLogger} by supplying
     its own factory type as a parameter.
  */
  public 
  static
  Logger getLogger(String name) {
    return Logger.getLogger(name, myFactory); 
  }

  public
  void trace(Object message) {
    super.log(FQCN, XLevel.TRACE, message, null); 
  }
  
  public
  void setLevel(Level level) {
    super.setLevel(level); 
  }
}
