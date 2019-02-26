/*
Authors: Tucker McCoy and Erick Ponce 
Program: Homework 1 
Date: 5/21/2018
Description: IS System for a small HVAC comapany that allows them to run their
daily operations smoothly
*/
package Homework1;

public class Service {
    public String serviceID; 
    public String serviceName;
    public String serviceLevel;
    public double servicePrice;
    public String technicianName;
    public static int serviceCount = 0;
    
    public Service(String serviceName, String serviceLevel, double servicePrice, String technicianName)
    {
        this.serviceID = "Service#" + serviceCount++;
        this.serviceName = serviceName;
        this.serviceLevel = serviceLevel;
        this.servicePrice = servicePrice;
        this.technicianName = technicianName;
        //serviceCount++;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(String serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    public double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }
    
    
    
}
