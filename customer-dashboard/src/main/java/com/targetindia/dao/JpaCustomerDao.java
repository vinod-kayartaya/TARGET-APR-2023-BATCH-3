package com.targetindia.dao;

import com.targetindia.model.Customer;
import com.targetindia.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class JpaCustomerDao implements CustomerDao {
    @Override
    public void addCustomer(Customer customer) throws DaoException {
        try (EntityManager em = JpaUtil.entityManager()) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            try {
                em.persist(customer);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw new DaoException(e);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Customer findById(long id) throws DaoException {
        try (EntityManager em = JpaUtil.entityManager()) {
            return em.find(Customer.class, id);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void updateCustomer(Customer customer) throws DaoException {
        try (EntityManager em = JpaUtil.entityManager()) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            try {
                em.merge(customer);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw new DaoException(e);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void deleteCustomer(long id) throws DaoException {
        try (EntityManager em = JpaUtil.entityManager()) {
            Customer c1 = em.find(Customer.class, id);
            if (c1 == null) {
                throw new DaoException("No customer found for id " + id);
            }
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            try {
                em.remove(c1);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw new DaoException(e);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Customer> getAllCustomers() throws DaoException {
        try (EntityManager em = JpaUtil.entityManager()) {
            return em.createQuery("from Customer", Customer.class).getResultList();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Customer> getCustomersByCity(String city) throws DaoException {
        try (EntityManager em = JpaUtil.entityManager()) {
            String ql = "from Customer where lower(city) = lower(?1)";
            TypedQuery<Customer> qry = em.createQuery(ql, Customer.class);
            qry.setParameter(1, city);
            return qry.getResultList();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Customer getCustomerByEmailOrPhone(String emailOrPhone) throws DaoException {
        try (EntityManager em = JpaUtil.entityManager()) {
            String ql = "from Customer where lower(email) = lower(?1) or phone=?1";
            TypedQuery<Customer> qry = em.createQuery(ql, Customer.class);
            qry.setParameter(1, emailOrPhone);
            return qry.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Customer> getCustomersByAge(int minAge, int maxAge) throws DaoException {
        return null;
    }
}
