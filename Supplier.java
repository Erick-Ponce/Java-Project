/*
Authors: Tucker McCoy and Erick Ponce 
Program: Homework 1 
Date: 5/21/2018
Description: IS System for a small HVAC comapany that allows them to run their
daily operations smoothly
*/
package Homework1;

public class Supplier {
    public String supplierID;
    public String supplierName;
    public String supplierAddress;
    public String supplierPhoneNumber;
    public String supplierEmail;
    public static int supplierCount = 0;
    
    public Supplier(String supplierName, String supplierAddress, String supplierPhoneNumber, String supplierEmail)
    {
        this.supplierID = "SupplierID" + supplierName.substring(0, 2) + supplierCount++;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.supplierPhoneNumber = supplierPhoneNumber;
        this.supplierEmail = supplierEmail;
        //supplierCount++;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierPhoneNumber() {
        return supplierPhoneNumber;
    }

    public void setSupplierPhoneNumber(String supplierPhoneNumber) {
        this.supplierPhoneNumber = supplierPhoneNumber;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }
    
    
}
