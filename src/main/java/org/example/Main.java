package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Inventory> companyList = FileManager.getStock();

    }

    public static void displayItems(List<Inventory> companyList){
        for(Inventory s : companyList){
            System.out.println(s.toString());
        }
    }

    public static void findItemByName(List<Inventory> companyList,String name){
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