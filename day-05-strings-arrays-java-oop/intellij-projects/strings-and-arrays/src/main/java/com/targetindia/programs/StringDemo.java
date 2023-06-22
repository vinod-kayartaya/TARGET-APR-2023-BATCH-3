package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringDemo {
    public static void main(String[] args) {

        String name = new String("Vinod Kumar K");
        String anotherName = new String("Vinod Kumar K");

        log.trace("name is '{}' and anotherName is '{}'", name, anotherName);
        log.trace("name==anotherName is {}", name == anotherName); // checks references
        log.trace("name.equals(anotherName) is {}", name.equals(anotherName)); // checks values

        String city = "Bangalore";
        String anotherCity = "Bangalore";
        String oneMoreCity = new String("Bangalore");

        log.trace("city is '{}' and anotherCity is '{}'", city, anotherCity);
        log.trace("city==anotherCity is {}", city == anotherCity); // checks references
        log.trace("city.equals(anotherCity) is {}", city.equals(anotherCity)); // checks values

        log.trace("city==oneMoreCity is {}", city==oneMoreCity);
        log.trace("city.equals(oneMoreCity) is {}", city.equals(oneMoreCity)); // checks values


    }
}
