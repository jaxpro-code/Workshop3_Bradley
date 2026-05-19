package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.example.Inventory.*;

public class Cart {


    public static List<Inventory> cart = new ArrayList<>();

    public static void displayCart(List<Inventory> cart){
        for(Inventory s : cart){
            System.out.println(s.toString());
        }
        System.out.println("\n1) Check Out" +
                "\n2) Remove Product" +
                "\n3) Go Back");
    }


    public static void addToCart(Scanner scanner){
        System.out.println("Which product would you like to add to cart?");

        String product = scanner.nextLine();
        for(Inventory s : cart){
            if(s.getName().equalsIgnoreCase(product)){
                if(s.getQuantity() < 1) {
                    cart.add(s);
                    s.setQuantity(+1);
                }
                else{
                    quantity(s);
                }
            }
        }

    }


    public static void removeFromCart(Scanner scanner){
        System.out.println("which product would you like to remove");
        String product = scanner.nextLine();
        for(Inventory s : cart) {
            if (s.getName().equalsIgnoreCase(product)) {
                cart.remove(product);
            }
        }
    }

    public static void quantity(Inventory product){
        for(Inventory c:cart){
            if(c == product){
                c.setQuantity(+1);
            }
        }
    }


    public static double getCartTotal(){
        double total = 0;
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
