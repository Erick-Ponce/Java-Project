/*
Authors: Tucker McCoy and Erick Ponce 
Program: Homework 1 
Date: 5/21/2018
Description: IS System for a small HVAC comapany that allows them to run their
daily operations smoothly
*/
package Homework1;

public class Transaction {
    public String transactionID;
    public String transactionType;
    public double transactionPrice;
    public static int transactionCount = 0;
    
    public Transaction(String transactionType, double transactionPrice)
    {
        this.transactionID = "TransactionID: " + transactionType.substring(0, 2) + transactionCount++;
        this.transactionType = transactionType;
        this.transactionPrice = transactionPrice;
        //transactionCount++;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getTransactionPrice() {
        return transactionPrice;
    }

    public void setTransactionPrice(double transactionPrice) {
        this.transactionPrice = transactionPrice;
    }
    
    
    
}
