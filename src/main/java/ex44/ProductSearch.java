/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution, Exercise 44
 *  Copyright 2021 Mayank Goyal
 */

package ex44;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

//for reading json file you will need to add external library, json-simple-1.1.1.jar
public class ProductSearch {
    public String productName;
    public String inputFile;

    public ProductSearch(){}

    public HashMap<JSONObject, Integer> search()
    {
        //create json parser object
        JSONParser parser = new JSONParser();
        JSONObject product = new JSONObject();
        //initialize isProductFound to zero and update to 1 if the product is found
        int isProductFound = 0;

        //Read json file using parser and store it in obj
        Object obj = null;
        try {
            obj = parser.parse(new FileReader(inputFile));
            //Create json object to read internal values
            JSONObject jsonObject = (JSONObject)obj;
            //Reading products array from  the file
            JSONArray subjects = (JSONArray)jsonObject.get("products");

            //declare variables
            String input;

            //Create iterator for products array
            Iterator iterator = subjects.iterator();
            JSONObject json = new JSONObject();
            //Loop through the iterator
            while (iterator.hasNext()) {
                //Create another json
                json = (JSONObject) iterator.next();
                //Get the name value
                String name = (String)json.get("name");
                //Compare it with given input
                if(productName.toLowerCase().equals(name.toLowerCase())){
                    product = json;
                    isProductFound = 1;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //return json obj with product that the user is searching for and flag to check if the product was found
        // if product not found return an empty obj
        HashMap<JSONObject, Integer> hm = new HashMap<JSONObject, Integer>();
        hm.put(product, isProductFound);
        return hm;
    }
}