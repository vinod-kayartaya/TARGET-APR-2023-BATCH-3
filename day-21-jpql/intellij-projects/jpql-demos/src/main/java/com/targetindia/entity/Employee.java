package com.targetindia.entity;

import com.targetindia.model.Address;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name="employee_id")
    private Integer employeeId;
    @Column(name="last_name")
    private String lastname;
    @Column(name="first_name")
    private String firstname;
    @Column
    private String title;
    @Column(name="title_of_courtesy")
    private String titleOfCourtesy;
    @Column(name="birth_date")
    private Date birthDate;
    @Column(name="hire_date")
    private Date hireDate;
    @Embedded
    private Address address; // has 5 properties that correspond to 5 columns of suppliers table

    @Column(name="home_phone")
    private String homePhone;
    @Column
    private String extension;
    @Column
    private String notes;
    @Column
    private byte[] photo;

    // this employee (and many others) reports to another employee
    // many to one
    @ManyToOne
    @JoinColumn(name="reports_to")
    private Employee manager;

    // if this employee is a manager
    @OneToMany
    @JoinColumn(name="reports_to")
    private List<Employee> subordinates;
}
