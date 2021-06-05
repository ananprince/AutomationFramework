package com.homework.testcases;

import org.apache.log4j.Logger;

/**
 * @Project: automation
 * @Author: 54540
 * @Create: 2021-05-23 07:46
 * @Desc：
 **/
public class LoggerTest {
    private static Logger logger = Logger.getLogger(LoggerTest.class);

    public static void main(String[] args) {


        logger.debug("debug级别的日志");
        logger.info("info级别的日志");
        logger.warn("warn级别的日志");
        logger.error("error级别的日志");

    }
}