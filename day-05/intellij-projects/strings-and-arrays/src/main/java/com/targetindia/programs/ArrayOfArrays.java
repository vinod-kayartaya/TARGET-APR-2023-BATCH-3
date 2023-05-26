package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArrayOfArrays {
    public static void main(String[] args) {
        String[][] contacts = {
                {"Vinod", "Kumar", "vinod@vinod.co", "9731424784"},
                {"Shyam", "Sundar", "shyam@xmpl.com", "92828222221"},
                {"Kishore", "Kumar", "kishore@xmpl.com", "9222388338"}
        };

        log.trace("length of contacts = {}", contacts.length);
        log.trace("length of first element of contacts is {}", contacts[0].length);
        log.trace("contacts[0][0] is {}", contacts[0][0]);

        for(int i=0; i<contacts.length; i++){
            String[] c = contacts[i];
            log.trace("contact #{} is: ", i+1);
            log.trace("Name = {} {}, Email = {}, Phone = {}", c[0], c[1], c[2], c[3]);
        }
    }
}
