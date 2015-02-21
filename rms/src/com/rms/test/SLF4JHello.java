package com.rms.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author srccodes.com
 * @version 1.0
 */
public class SLF4JHello {
    private final Logger slf4jLogger = LoggerFactory.getLogger(SLF4JHello.class);

    /**
     * Print hello in log.
     * 
     * @param name
     */
    public void sayHello(String name) {
    	
       slf4jLogger.info("Hi, {}", name);
       slf4jLogger.info("Welcome to the HelloWorld example of SLF4J");
       slf4jLogger.error("Test error");  
       slf4jLogger.warn("Test Warning");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SLF4JHello slf4jHello = new SLF4JHello();
        slf4jHello.sayHello("This is a log statement");
    }
}