/*
Authors: Tucker McCoy and Erick Ponce 
Program: Homework 1 
Date: 5/21/2018
Description: IS System for a small HVAC comapany that allows them to run their
daily operations smoothly
*/
package Homework1;

public class Customer {
    public String customerID;
    public String customerName;
    public String customerPhoneNumber;
    public String customerAddress;
    public String customerEmail;
    public static int customerCount = 0;
    
    public Customer(String customerName, String customerPhoneNumber, String customerAddress, String customerEmail)
    {
        this.customerID = "CustomerID: " + customerName.substring(0, 2) + customerCount++;
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
        //++customerCount;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
    public String toString(){ 
        return "Customer ID: " + this.customerID + "Customer Name: " + this.customerName +
                "Customer Products: " + "Customer Services: ";
    }
}
