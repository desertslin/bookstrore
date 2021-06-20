package com.deserts.test;

import com.deserts.utils.JdbcUtils;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;

/**
 * @ClassName JdbcUtilsTest
 * @Description TODO
 * @Author deserts
 * @Date 2020/8/11 17:53
 */
public class JdbcUtilsTest {
    public static void main(String[] args) {
        Connection connection = JdbcUtils.getConnection();
        System.out.println(connection);
        DbUtils.closeQuietly(connection);
    }
}
