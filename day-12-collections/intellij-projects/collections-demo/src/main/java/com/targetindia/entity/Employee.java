package com.targetindia.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Iterable<Object>{

    private int id;
    private String name;
    private String department;
    private double salary;

    class EmployeeIterator implements Iterator<Object>{
        Collection<Object> fields = Arrays.asList(id, name, department, salary);
        Iterator<Object> it= fields.iterator();
        @Override
        public boolean hasNext() {
            return it.hasNext();
        }
        @Override
        public Object next() {
            return it.next();
        }
    }

    @Override
    public Iterator<Object> iterator() {
        return new EmployeeIterator();
    }
}
