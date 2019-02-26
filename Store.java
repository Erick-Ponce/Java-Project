/*
Authors: Tucker McCoy and Erick Ponce 
Program: Homework 1 
Date: 5/21/2018
Description: IS System for a small HVAC comapany that allows them to run their
daily operations smoothly
*/
package Homework1;

public class Store {
    public String storeID;
    public String storeName;
    public String storeLocation;
    public String storePhoneNumber;
    public String storeAddress;
    public static int storeCount = 0;
    
    public Store(String storeName, String storeLocation, String storePhoneNumber, String storeAddress)
    {
        this.storeID = "StoreID: " + storeName.substring(0, 2) + storeCount++;
        this.storeName = storeName;
        this.storeLocation = storeLocation;
        this.storePhoneNumber = storePhoneNumber;
        this.storeAddress = storeAddress;
        //storeCount++;
    }

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }

    public String getStorePhoneNumber() {
        return storePhoneNumber;
    }

    public void setStorePhoneNumber(String storePhoneNumber) {
        this.storePhoneNumber = storePhoneNumber;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }
    
    
    
}
