package com.targetindia.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer implements Comparable<Customer> {
    private int id;
    private String name;
    private double rating;

    @Override
    public int compareTo(Customer other) {
        // this method defines the natural ordering between two objects of Customer class
        // this method must return:
        // -ve --> if this < other
        // 0 --> if this == other
        // +ve --> if this > other

        // return this.id - other.id;
        // return this.name.compareTo(other.name);
        // return Double.compare(this.rating, other.rating);
        int result = Integer.compare(this.id, other.id);
        if(result!=0) return result;

        result = this.name.compareTo(other.name);
        if(result!=0) return result;

        return Double.compare(this.rating, other.rating);
    }
}
