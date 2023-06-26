package com.targetindia.dao;

import com.targetindia.entity.Shipper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class JdbcShipperDao implements ShipperDao {

    // dependency
    @Autowired (required = false)
    // the above annotation instructs spring to find a bean in the container with
    // the name "dataSource" or by type "javax.sql.DataSource", and injects the same to this reference.
    // The element (required=false) indicate that Spring should not throw an exception when there is no
    // qualifying bean in the container.
    @Qualifier("basicDataSource")
    private DataSource dataSource;

    // default no arg constructor for good practice
    public JdbcShipperDao() {
        log.trace("JdbcShipperDao constructor called with hashCode = {}", this.hashCode());
    }

    // constructor for any dependency injection
    public JdbcShipperDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    // setter for any dependency injection
    // @Autowired
    // @Qualifier("jdbcDataSource")
    public void setDataSource(DataSource dataSource) {
        log.trace("a dataSource of {} class is received by JdbcShipperDao.setDataSource() method",
                dataSource.getClass().getName());
        this.dataSource = dataSource;
    }

    @Override
    public void add(Shipper shipper) throws DaoException {
        throw new DaoException("method under development");
    }

    @Override
    public Shipper get(Integer shipperId) throws DaoException {
        String sql = "select * from shippers where shipper_id=?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, shipperId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapRowToShipper(rs);
                }
                return null;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(Shipper shipper) throws DaoException {
        throw new DaoException("method under development");
    }

    @Override
    public void delete(Integer shipperId) throws DaoException {
        throw new DaoException("method under development");
    }

    @Override
    public long count() throws DaoException {
        log.trace("dataSource in JdbcShipperDao is of type {}", dataSource.getClass().getName());
        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select count(*) from shippers");
        ) {
            rs.next();
            return rs.getLong(1);
        } // conn/stmt/rs will be closed here
        catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Shipper> getAll() throws DaoException {
        List<Shipper> list = new ArrayList<>();
        String sql = "select * from shippers";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(mapRowToShipper(rs));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return list;
    }

    private static Shipper mapRowToShipper(ResultSet rs) throws SQLException {
        Shipper s = new Shipper();
        s.setCompanyName(rs.getString("company_name"));
        s.setPhone(rs.getString("phone"));
        s.setShipperId(rs.getInt("shipper_id"));
        return s;
    }

    @Override
    public Shipper getByPhone(String phone) throws DaoException {
        throw new DaoException("method under development");
    }
}
