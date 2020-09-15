package com.wuning.test;

import com.wuning.utils.JdbcUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author wu
 * @date 2020-04-17 23:38
 */

public class JdbcUtilTest {
    @Test
    public void test() throws SQLException {
        for (int i = 0; i <100 ; i++) {
            Connection conn = JdbcUtil.getConnection();
            System.out.println(conn);
            JdbcUtil.commitAndClose();
        }
    }
}
