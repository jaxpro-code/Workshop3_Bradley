package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    public List<Inventory> cart = new ArrayList<>();

    public static void displayCart(List<Inventory> cart){
        for(Inventory s : cart){
            System.out.println(s.toString());
        }
    }


    public void addToCart(Inventory product){
        if(product.getQuantity() < 1) {
            cart.add(product);
            product.setQuantity(+1);
        }
        else{
            quantity(product);
        }
    }


    public void removeFromCart(Inventory product){
        cart.remove(product);
    }

    public void quantity(Inventory product){
        for(Inventory c:cart){
            if(c == product){
                c.setQuantity(+1);
            }
        }
    }

    double total = 0;
    public double getCartTotal(){

        for(Inventory c : cart){
            total += c.getPrice();
        }
        return total;
    }

    public void printReceipt(List<Inventory> cart) {

        System.out.println("---- Receipt ----");

        for (Inventory c : cart) {
            System.out.printf("%-20s $%8.2f%n", c.getName(), c.getPrice());
        }

        System.out.println("----------------");
        System.out.printf(" Total          $%8.2f%n", getCartTotal());
        System.out.println("---- Thank you ----");


    }




//    public void quantitytest (Inventory product){
//        //if in cart is false add to cart and redefine in cart as true
//        for(Inventory c : cart){
//            if(c.isInCart() == false){
//                c.setInCart(true);
//            }
//            else if(c.isInCart() == true){
//                c.setQuantity(+1);
//
//
//            }
//        }
//        //if in cart is true
//    }
}
