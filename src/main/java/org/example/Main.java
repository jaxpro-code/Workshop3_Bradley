package org.example;

import java.util.List;
import java.util.Scanner;

import static org.example.Cart.*;
import static org.example.Inventory.homeScreen;

public class Main {
    public static void main(String[] args) {
        List<Inventory> companyList = FileManager.getStock();
        Scanner scanner = new Scanner(System.in);

        HOME:
        while(true){
            homeScreen();
            int uI = scanner.nextInt();

            switch (uI){
                case 1:
                    PRODUCTS:
                    {
                        displayItems(companyList);
                        int UI = scanner.nextInt();
                        switch (UI) {
                            case 1:
                                findItemByName(scanner);
                                break;
                            case 2:
                                addToCart(scanner);
                                break;
                            case 3:
                                break PRODUCTS;
                            default:
                                System.out.println("please make a selection");
                                break;
                        }
                    }
                    break;
                case 2:
                    CART:
                    {
                        displayCart(companyList);
                        int Ui = scanner.nextInt();
                        switch(Ui){
                            case 1:
                                getCartTotal();
                                break;
                            case 2:
                                removeFromCart(scanner);
                            case 3:
                                break CART;
                            default:
                                System.out.println("please make a selection");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Thank you, Have a Nice Day!");
                    System.exit(0);
            }
        }

    }

    public static void displayItems(List<Inventory> companyList){
        for(Inventory s : companyList){
            System.out.println(s.toString());
        }
        System.out.println("\n1) Search Product" +
                "\n2) Add to Cart" +
                "\n3) Go Back to Home Screen");
    }

    public static void findItemByName(Scanner scanner){
        List<Inventory> companyList = FileManager.getStock();
        String name = scanner.nextLine();
        for(Inventory i : companyList){
            if(i.getName() == name){
                System.out.println(i.toString());
                return;
            }
        }

        System.out.println("Sorry, we don't have a product with that name");
    }

    public static void priceRange(List<Inventory> companyList,double min,double max) {
        for(Inventory s : companyList){
            if(s.getPrice() >= min && s.getPrice() <= max){
                System.out.println(s.toString());
            }
        }
    }

    public static void findItemByDepartment(List<Inventory> companyList,String department){
        for(Inventory i : companyList){
            if(i.getDepartment() == department){
                System.out.println(i.toString());
                return;
            }
        }

        System.out.println("Sorry, we don't have that shopping department");
    }
}