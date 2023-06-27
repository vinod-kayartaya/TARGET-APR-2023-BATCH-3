package com.targetindia.dao;

import com.targetindia.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcTemplateProductDao implements ProductDao {

    @Autowired
    private JdbcTemplate template;

    // row mapper for product
    private static RowMapper<Product> productRowMapper = (rs, rowNum) -> {
        Product p = new Product();
        p.setProductId(rs.getInt("product_id"));
        p.setProductName(rs.getString("product_name"));
        p.setCategoryId(rs.getInt("category_id"));
        p.setSupplierId(rs.getInt("supplier_id"));
        p.setQuantityPerUnit(rs.getString("quantity_per_unit"));
        p.setUnitPrice(rs.getDouble("unit_price"));
        p.setUnitsInStock(rs.getInt("units_in_stock"));
        p.setUnitsOnOrder(rs.getInt("units_on_order"));
        p.setReorderLevel(rs.getInt("reorder_level"));
        p.setDiscontinued(rs.getInt("discontinued"));
        return p;
    };

    @Override
    public void add(Product product) throws DaoException {

    }

    @Override
    public Product findById(Integer productId) throws DaoException {
        try {
            String sql = "select * from products where product_id=?";
            return template.queryForObject(sql, productRowMapper, productId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void update(Product p) throws DaoException {
        String sql = "update products set product_name=?, category_id=?, supplier_id=?, quantity_per_unit=?, " +
                "unit_price=?, units_in_stock=?, units_on_order=?, reorder_level=?, discontinued=? where product_id=?";
        PreparedStatementCallback<Integer> psc = (ps)->{
            ps.setString(1, p.getProductName());
            ps.setInt(2, p.getCategoryId());
            ps.setInt(3, p.getSupplierId());
            ps.setString(4, p.getQuantityPerUnit());
            ps.setDouble(5, p.getUnitPrice());
            ps.setInt(6, p.getUnitsInStock());
            ps.setInt(7, p.getUnitsOnOrder());
            ps.setInt(8, p.getReorderLevel());
            ps.setInt(9, p.getDiscontinued());
            ps.setInt(10, p.getProductId());
            return ps.executeUpdate();
        };

        template.execute(sql, psc);
    }

    @Override
    public void delete(Integer productId) throws DaoException {

    }

    @Override
    public long count() throws DaoException {
        return template.queryForObject("select count(*) from products", Long.class);
    }

    @Override
    public List<Product> findAll() throws DaoException {
        return template.query("select * from products", productRowMapper);
    }

    @Override
    public List<Product> findAllByCategoryId(Integer categoryId) throws DaoException {
        return template.query("select * from products where category_id=?", productRowMapper, categoryId);
    }

    @Override
    public List<Product> findAllBySupplierId(Integer supplierId) throws DaoException {
        return template.query("select * from products where supplier_id=?", productRowMapper, supplierId);
    }

    @Override
    public List<Product> findAllDiscontinuedProducts() throws DaoException {
        return template.query("select * from products where discontinued=1", productRowMapper);
    }

    @Override
    public List<Product> findAllOutOfStockProducts() throws DaoException {
        return template.query("select * from products where units_in_stock=0", productRowMapper);
    }

    @Override
    public List<Product> findAllByPriceRange(double min, double max) throws DaoException {
        return template.query("select * from products where unit_price between ? and ? order by unit_price",
                productRowMapper, min, max);
    }
}
