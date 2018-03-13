package com.ustcck;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by CaoKai on 2018/3/13 13:44.
 * Email:caokai@yijiahe.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

    //private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void hehe() {
        String name = "ustcck";
        String password = "123456";
        log.debug("debug...");
        log.info("info...");
        log.info("name =" + name + "password =" + password);
        log.info("name = {}, password = {}", name, password);
        log.error("error...");
    }
}
