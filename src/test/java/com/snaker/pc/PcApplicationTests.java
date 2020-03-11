package com.snaker.pc;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PcApplicationTests {

//    @Test
//    public void contextLoads() {
//        Logger logger1 = LoggerFactory.getLogger(getClass());
//        logger1.info("yyy");
//    }
    @Autowired
    DataSource dataSource;
    @Test
    public void contextLoads() throws SQLException {

       // String url = ResourceUtils.getURL("classpath:").getPath();
        System.out.println(dataSource.getClass());
        Connection con = dataSource.getConnection();
        System.out.println(con);
    }

}
