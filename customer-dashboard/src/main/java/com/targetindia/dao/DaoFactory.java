package com.targetindia.dao;

import java.util.ResourceBundle;

public final class DaoFactory {
    private DaoFactory() {
    }

    public static CustomerDao getCustomerDao() throws DaoException{
        // let's read the discriminator from "dao-impl.properties" file
        ResourceBundle rb = ResourceBundle.getBundle("dao-impl"); // looks for dao-impl.properties file
        // String descriminator= rb.getString("CustomerDao.impl.discriminator");
        // return getCustomerDao(descriminator);

        String customerDaoImplClassName = rb.getString("CustomerDao.impl.class");
        try {
            return (CustomerDao) Class.forName(customerDaoImplClassName).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public static CustomerDao getCustomerDao(String discriminator){
        switch(discriminator.toLowerCase()){
            case "csv":
                return new CsvCustomerDao();
            case "arraylist":
                return new ArrayListCustomerDao();
            case "hashmap":
                return new HashMapCustomerDao();
            default:
                throw new DaoException("Invalid discriminator");
        }
    }

}
