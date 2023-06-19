package com.targetindia.programs;

import com.targetindia.entity.LineItem;
import com.targetindia.entity.Order;
import com.targetindia.utils.DateUtil;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;

public class GetOneOrder {
    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("Enter order id to search: ");
        try (EntityManager em = JpaUtil.entityManager()) {
            Order order1 = em.find(Order.class, id);
            printOrder(order1);
        }
    }

    public static void printOrder(Order order1) {
        System.out.printf("Order id       : %d%n", order1.getOrderId());
        System.out.printf("Order date     : %s%n", DateUtil.toString(order1.getOrderDate()));
        System.out.printf("Required date  : %s%n", DateUtil.toString(order1.getRequiredDate()));
        System.out.printf("Shipped date   : %s%n", DateUtil.toString(order1.getShippedDate()));

        System.out.printf("Customer       : %s (%s, %s)%n", order1.getCustomer().getCompanyName(),
                order1.getCustomer().getAddress().getCity(),
                order1.getCustomer().getAddress().getCountry());
        System.out.printf("Employee       : %s%s %s (%s)%n",
                order1.getEmployee().getTitleOfCourtesy(),
                order1.getEmployee().getFirstname(),
                order1.getEmployee().getLastname(),
                order1.getEmployee().getTitle());
        System.out.printf("Shipped by     : %s (%s)%n",
                order1.getShipper().getCompanyName(),
                order1.getShipper().getPhone());
        System.out.printf("Freight charges: $%.2f%n", order1.getFreight());
        System.out.printf("Shipping to    : %s%n", order1.getShipToName());
        System.out.printf("                 %s%n", order1.getShipToAddress().getStreetAddress());
        System.out.printf("                 %s %s%n", order1.getShipToAddress().getCity(),
                order1.getShipToAddress().getRegion());
        System.out.printf("                 %s%n", order1.getShipToAddress().getCountry());

        double total = 0;
        double discount = 0;
        System.out.printf("%-35s %10s %4s %10s %10s%n",
                "Product", "Price", "Qty", "Discount", "Amount");
        System.out.println("-------------------------------------------------------------------------");
        for(LineItem li: order1.getLineItems()){
            double amount = li.getQuantity()*li.getUnitPrice()*(1-li.getDiscount());
            if(li.getDiscount()>0){
                discount += li.getQuantity()*li.getUnitPrice()*li.getDiscount();
            }
            System.out.printf("%-35s %10.2f %4d %10.2f %10.2f%n",
                    li.getProduct().getProductName(),
                    li.getUnitPrice(),
                    li.getQuantity(),
                    li.getDiscount(),
                    amount);
            total+=amount;
        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("%62s %10.2f\n", "", total);
        System.out.println("-------------------------------------------------------------------------");
        if(discount>0){
            System.out.printf("You saved $%.2f in this order!%n", discount);
        }

    }
}
