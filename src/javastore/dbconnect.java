/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastore;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.*;


public class dbconnect {
MysqlDataSource dataSource = new MysqlDataSource();
dataSource.setUser("scott");
dataSource.setPassword("tiger");
dataSource.setServerName("myDBHost.example.org");
}
