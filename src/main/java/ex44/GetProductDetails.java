/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution, Exercise 44
 *  Copyright 2021 Mayank Goyal
 */

package ex44;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Scanner;

public class GetProductDetails {
    public static void main(String[] args) {
        ProductSearch ps = new ProductSearch();
        ps.inputFile = "src/main/resources/exercise44_input.txt";

        Scanner sc = new Scanner(System.in);
        System.out.print("What is the product name? ");
        ps.productName = sc.nextLine();
        HashMap<JSONObject, Integer> response = ps.search();

        JSONObject product = response.keySet().iterator().next();
        Integer isFound = response.get(product);

        if(isFound == 1)
        {
            System.out.println("Name: " + product.get("name"));
            System.out.println("Price: " + product.get("price"));
            System.out.println("Quantity: " + product.get("quantity"));
        }
        else
        {
            System.out.println("Sorry, that product was not found in our inventory");
        }

    }
}