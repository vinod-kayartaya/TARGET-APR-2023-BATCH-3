package com.targetindia.dao;

import com.targetindia.entity.Shipper;

import java.util.List;

public interface ShipperDao {
    public void add(Shipper shipper) throws DaoException;

    public Shipper get(Integer shipperId) throws DaoException;

    public void update(Shipper shipper) throws DaoException;

    public void delete(Integer shipperId) throws DaoException;

    public long count() throws DaoException;

    public List<Shipper> getAll() throws DaoException;

    public Shipper getByPhone(String phone) throws DaoException;
}
