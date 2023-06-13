package com.targetindia.dao;

import com.targetindia.model.Customer;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class JdbcCustomerDao implements CustomerDao {
    @SneakyThrows
    private Connection createConnection() {
        ResourceBundle rb = ResourceBundle.getBundle("jdbc-info");
        String url = rb.getString("jdbc.connection.url");
        String user = rb.getString("jdbc.connection.user");
        String password = rb.getString("jdbc.connection.password");
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void addCustomer(Customer c) throws DaoException {
        String sql = "insert into customers (first_name, last_name, email, phone, city, birth_date) values (?,?,?,?,?,?)";
        try (Connection conn = this.createConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, c.getFirstname());
            stmt.setString(2, c.getLastname());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getPhone());
            stmt.setString(5, c.getCity());
            stmt.setDate(6, new java.sql.Date(c.getBirthDate().getTime()));

            stmt.executeUpdate();

        }catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Customer findById(long id) throws DaoException {
        String sql = "select * from customers where id = ?";
        try (Connection conn = this.createConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return toCustomer(rs);
                } // rs.close()
                return null;
            } // stmt.close(), conn.close()
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    private static Customer toCustomer(ResultSet rs) throws SQLException {
        Customer c = new Customer();
        c.setId(rs.getInt("id"));
        c.setFirstname(rs.getString("first_name"));
        c.setLastname(rs.getString("last_name"));
        c.setEmail(rs.getString("email"));
        c.setPhone(rs.getString("phone"));
        c.setCity(rs.getString("city"));
        c.setBirthDate(rs.getDate("birth_date"));
        return c;
    }

    @Override
    public void updateCustomer(Customer customer) throws DaoException {

    }

    @Override
    public void deleteCustomer(long id) throws DaoException {
        String sql = "delete from customers where id=?";
        try (Connection conn = this.createConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Customer> getAllCustomers() throws DaoException {
        List<Customer> list = new ArrayList<>();

        String sql = "select * from customers";
        try (Connection conn = this.createConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery();
        ) {
            while (rs.next()) {
                // create and add a new Customer object for every record in rs
                list.add(toCustomer(rs));
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return list;
    }

    @Override
    public List<Customer> getCustomersByCity(String city) throws DaoException {
        List<Customer> list = new ArrayList<>();

        String sql = "select * from customers where lower(city)=lower(?)";
        try (Connection conn = this.createConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);

        ) {
            stmt.setString(1, city);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // create and add a new Customer object for every record in rs
                    list.add(toCustomer(rs));
                }
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return list;
    }

    @Override
    public Customer getCustomerByEmailOrPhone(String emailOrPhone) throws DaoException {
        String sql = "select * from customers where lower(email)=lower(?) or phone=?";
        try (Connection conn = this.createConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);

        ) {
            stmt.setString(1, emailOrPhone);
            stmt.setString(2, emailOrPhone);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // create and add a new Customer object for every record in rs
                    return toCustomer(rs);
                }
                return null;
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Customer> getCustomersByAge(int minAge, int maxAge) throws DaoException {
        String sql = "select * from customers where year(sysdate) - year(birth_date)  between ? and ?";
        List<Customer> list = new ArrayList<>();
        try (Connection conn = this.createConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setInt(1, minAge);
            stmt.setInt(2, maxAge);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    list.add(toCustomer(rs));
                }
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return list;
    }
}
