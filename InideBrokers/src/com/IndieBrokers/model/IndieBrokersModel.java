/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.IndieBrokers.model;

/**
 *
 * @author forea
 */
public class IndieBrokersModel {
    private int BrokerID;
    private String Brokername;
    private String Contact;
    private String BankName;
    private short Collateral;
    private int Experience;
        
    
    public IndieBrokersModel (int BrokerID, String Brokername, String BankName, String Contact,  short Collateral, int Experience){
        this.BrokerID = BrokerID;
        this.Brokername = Brokername;
        this.BankName = BankName;
        this.Contact = Contact;
        this.Collateral = Collateral;
        this.Experience = Experience;
    }

  
    
    public int getBrokerID() {
        return BrokerID;
    }

    public void setBrokerID(int BrokerID) {
        this.BrokerID = BrokerID;
    }
   

    public String getBrokername() {
        return Brokername;
    }

    public void setBrokername(String Brokername) {
        this.Brokername = Brokername;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String BankName) {
        this.BankName = BankName;
    }

    public short getCollateral() {
        return Collateral;
    }

    public void setCollateral(short Collateral) {
        this.Collateral = Collateral;
    }
    
      public int getExperience() {
        return Experience;
    }

    public void setExperience(int Experience) {
        this.Experience = Experience;
    }
    
}
