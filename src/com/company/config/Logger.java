package com.company.config;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.logging.*;

/**
 * 日志简易封装类
 * @author 攀博课堂(www.pbteach.com)
 * @version 1.0
 **/
public class Logger {
    private static LogManager logManager = LogManager.getLogManager();
    static {
        InputStream inputStream = null;
        try {
            inputStream = Logger.class.getClassLoader().getResourceAsStream("logging.properties");
            logManager.readConfiguration(inputStream);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private java.util.logging.Logger logger;

    public static Logger getLogger(Class clzz){
       return new Logger(clzz.getName());
    }

    private Logger(String name){
        logger = java.util.logging.Logger.getLogger(name);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFormatter(new CustomFormat());
        logger.addHandler(handler);
        logger.setLevel(Level.ALL);
        logManager.addLogger(logger);
    }

    /**
     * 调试信息
     * @param msg
     */
    public void debug(String msg){
        logger.fine(msg);
    }

    /**
     * 一般信息
     * @param msg
     */
    public void info(String msg){
        logger.info(msg);
    }

    /**
     * 警告信息
     * @param msg
     */
    public void warn(String msg){
        logger.warning(msg);
        System.out.println();
    }


    class CustomFormat extends Formatter {
        @Override
        public String format(LogRecord log) {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.S");

            return  format.format(log.getMillis())+" "+log.getLevel()+" "+log.getLoggerName()+"["+Thread.currentThread().getName()+"] - " +log.getMessage()+"\n";
        }

    }


}
