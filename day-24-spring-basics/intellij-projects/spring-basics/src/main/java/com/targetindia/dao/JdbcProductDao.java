package com.targetindia.dao;

import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
public class JdbcProductDao implements ProductDao {

    // dependency on a connection pool is expressed as a member variable
    private DataSource dataSource; // defaults to 'null'

    public JdbcProductDao() {
    }

    // this can be used by spring for injecting the dependency
    public JdbcProductDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // writable property or mutator
    // can be used by spring to inject/wire dependency
    public void setDataSource(DataSource dataSource) { // property name is "connectionPool"
        log.trace("JdbcProductDao.setDataSource called with an object {} class", dataSource.getClass().getName());
        this.dataSource = dataSource;
    }

    @Override
    public long count() throws DaoException {
        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select count(*) from products");
        ) {
            rs.next();
            return rs.getLong(1);
        } // conn/stmt/rs will be closed here
        catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
