package com.targetindia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shipper {
    private Integer shipperId;
    private String companyName;
    private String phone;
}
