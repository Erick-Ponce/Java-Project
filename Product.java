/*
Authors: Tucker McCoy and Erick Ponce 
Program: Homework 1 
Date: 5/21/2018
Description: IS System for a small HVAC comapany that allows them to run their
daily operations smoothly
*/
package Homework1;

public class Product {
    public String productID;
    public String productName;
    public double productPrice;
    public String productDescription;
    public static int productCount = 0;
    
    public Product(String productName, double productPrice, String productDescription)
    {
        this.productID = "ProductID: " + productName.substring(0, 2) + productCount++;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        //productCount++;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    
    
    
}
