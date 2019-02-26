/*
Authors: Tucker McCoy and Erick Ponce 
Program: Homework 1 
Date: 5/21/2018
Description: IS System for a small HVAC comapany that allows them to run their
daily operations smoothly
*/
package Homework1;

public class SalesPerson {
    public String salesPersonID;
    public String salesPersonName;
    public String salesPersonPhoneNumber;
    public String salesPersonEmail;
    public static int salesPersonCount = 0;
    
    public SalesPerson(String salesPersonName, String salesPersonPhoneNumber, String salesPersonEmail)
    {
        this.salesPersonID = "SalesPersonID: " + salesPersonName.substring(0, 2) + salesPersonCount++;
        this.salesPersonName = salesPersonName;
        this.salesPersonPhoneNumber = salesPersonPhoneNumber;
        this.salesPersonEmail = salesPersonEmail;
        //salesPersonCount++;
    }

    public String getSalesPersonID() {
        return salesPersonID;
    }

    public void setSalesPersonID(String salesPersonID) {
        this.salesPersonID = salesPersonID;
    }

    public String getSalesPersonName() {
        return salesPersonName;
    }

    public void setSalesPersonName(String salesPersonName) {
        this.salesPersonName = salesPersonName;
    }

    public String getSalesPersonPhoneNumber() {
        return salesPersonPhoneNumber;
    }

    public void setSalesPersonPhoneNumber(String salesPersonPhoneNumber) {
        this.salesPersonPhoneNumber = salesPersonPhoneNumber;
    }

    public String getSalesPersonEmail() {
        return salesPersonEmail;
    }

    public void setSalesPersonEmail(String salesPersonEmail) {
        this.salesPersonEmail = salesPersonEmail;
    }
    
    
    
}
