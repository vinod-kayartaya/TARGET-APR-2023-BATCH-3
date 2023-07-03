package com.targetindia.entity;

import com.targetindia.model.Address;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@Entity
@Table(name = "suppliers")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Supplier {
    @Id
    @Column(name="supplier_id")
    private Integer supplierId;
    @Column(name="company_name")
    private String companyName;
    @Column(name="contact_name")
    private String contactName;
    @Column(name="contact_title")
    private String contactTitle;

    @Embedded
    private Address address; // has 5 properties that correspond to 5 columns of suppliers table

    @Column
    private String phone;
    @Column
    private String fax;
    @Column(name="home_page")
    private String homepage;
}
