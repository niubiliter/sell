package com.huangliusong;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by huangliusong on 2017/8/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {
    private final Logger  logger= LoggerFactory.getLogger(LoggerTest.class);
    @Test
    public void test1(){
        logger.info("测试1-info");
        logger.debug("测试-debug");
        logger.error("error....");
    }
}
