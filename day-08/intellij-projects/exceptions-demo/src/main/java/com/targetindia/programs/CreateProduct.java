package com.targetindia.programs;

import com.targetindia.exceptions.BlankNameException;
import com.targetindia.exceptions.IdException;
import com.targetindia.exceptions.NullNameException;
import com.targetindia.exceptions.UnitPriceException;
import com.targetindia.model.Product;
import com.targetindia.utils.KeyboardUtil;

public class CreateProduct {
    public static void main(String[] args) {
        Product p1;
        p1 = new Product();

        int id = KeyboardUtil.getInt("Enter id: ");
        String name = KeyboardUtil.getString("Enter name: ");
        double price = KeyboardUtil.getDouble("Enter price: ");


        try {
            p1.setId(id);
            p1.setName(name);
            p1.setUnitPrice(price);
            p1.print();
        } catch (IdException e) {
            System.out.println("Invalid id supplied");
        } catch (NullNameException e) {
            System.out.println("Name cannot be null");
        } catch (BlankNameException e) {
            System.out.println("Name cannot be blank");
        } catch (UnitPriceException e) {
            System.out.println("Unit price is invalid");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

