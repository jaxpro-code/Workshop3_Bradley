package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static List<Inventory> getStock(){
        List<Inventory> getStock = new ArrayList<>();

        try{
            FileReader fileReader = new FileReader("src/main/resources/Products.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String input;

            while((input = bufferedReader.readLine()) != null){
                String[] csvRow = input.split("\\|");
                String sku = csvRow[0];
                String name = csvRow[1];
                double price = Double.parseDouble(csvRow[2]);
                String department = csvRow[3];
                boolean inCart = false;
                int quantity = 0;

                Inventory item = new Inventory(sku,name,price,department,inCart,quantity);
                getStock.add(item);
            }

            bufferedReader.close();
            return getStock;
        }
        catch (IOException ex) {
            System.out.println("there was a problem with this file ");
        }

        return new ArrayList<>();

    }

    public static void writeStock (Inventory item){
        try {
            File file = new File("src/main/resources/Hardware_inventory.csv");

            FileWriter fileWriter = new FileWriter(file, true);

            if (file.length() > 0) {
                fileWriter.write(System.lineSeparator());
            }

            fileWriter.write(String.format("%s|%s|%f|%s", item.getSku(), item.getName(), item.getPrice(), item.getDepartment()));

            fileWriter.close();
        }
        catch (IOException ex){
            System.out.println("error writing to file");
        }
    }
}
