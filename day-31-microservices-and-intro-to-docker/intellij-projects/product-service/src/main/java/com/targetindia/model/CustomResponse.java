package com.targetindia.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@XmlRootElement(name="response")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomResponse {
    private String message;
    private Date timestamp = new Date();

    public CustomResponse(String message) {
        this.message = message;
    }
}
