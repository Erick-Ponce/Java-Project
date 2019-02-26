/*
Authors: Tucker McCoy and Erick Ponce 
Program: Homework 1 
Date: 5/21/2018
Description: IS System for a small HVAC comapany that allows them to run their
daily operations smoothly
*/
package Homework1;

public class Technician {
    public String technicianID;
    public String technicianName;
    public String technicianPhoneNumber;
    public String technicianAddress;
    public static int technicianCount = 0;
    
    public Technician(String technicianName, String technicianPhoneNumber, String technicianAddress)
    {
        this.technicianID = "TechnicianID: " + technicianName.substring(0, 2) + technicianCount++;
        this.technicianName = technicianName;
        this.technicianPhoneNumber = technicianPhoneNumber;
        this.technicianAddress = technicianAddress;
        //technicianCount++;
    }

    public String getTechnicianID() {
        return technicianID;
    }

    public void setTechnicianID(String technicianID) {
        this.technicianID = technicianID;
    }

    public String getTechnicianName() {
        return technicianName;
    }

    public void setTechnicianName(String technicianName) {
        this.technicianName = technicianName;
    }

    public String getTechnicianPhoneNumber() {
        return technicianPhoneNumber;
    }

    public void setTechnicianPhoneNumber(String technicianPhoneNumber) {
        this.technicianPhoneNumber = technicianPhoneNumber;
    }

    public String getTechnicianAddress() {
        return technicianAddress;
    }

    public void setTechnicianAddress(String technicianAddress) {
        this.technicianAddress = technicianAddress;
    }
    
    
}
