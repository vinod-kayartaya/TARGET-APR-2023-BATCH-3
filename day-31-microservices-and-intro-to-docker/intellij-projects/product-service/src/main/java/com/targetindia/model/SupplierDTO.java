package com.targetindia.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name="supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierDTO {
    private Integer supplierId;
    private String companyName;
    private String contactName;
    private String contactTitle;
    private Address address;
    private String phone;
    private String fax;
    private String homepage;

    @Data
    class Address {
        private String streetAddress;
        private String city;
        private String region;
        private String postalCode;
        private String country;
    }
}

