
package com.IndieBrokers.controller;

import java.util.regex.Pattern;

/**
 *
 * @author forea
 */
public class ValidationUtil {
    private static final Pattern Broker_PATTERN = Pattern.compile("^[a-zA-Z\\s]+$");
    private static final Pattern BrokerID_PATTERN = Pattern.compile("^\\d{4}$");
    private static final Pattern BANK_PATTERN = Pattern.compile("^(global|nabil|siddhartha)$");
    private static final Pattern CONTACT_PATTERN = Pattern.compile("^98\\d{8}$");
    private static final Pattern Experience_PATTERN = Pattern.compile("^\\d{2}$");

    

    
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
    
    public static boolean isValidbroker(String name) {
        return !isNullOrEmpty(name) && Broker_PATTERN.matcher(name).matches();
    }
    
    public static boolean isValidbrokerID(String brokerid) {
        return !isNullOrEmpty(brokerid) && BrokerID_PATTERN.matcher(brokerid).matches();
    }
    
    public static boolean isValidBankName(String bankname) {
        return !isNullOrEmpty(bankname) && BANK_PATTERN.matcher(bankname).matches();
    }
    
    public static boolean isValidContact(String contact) {
        return !isNullOrEmpty(contact) && CONTACT_PATTERN.matcher(contact.toLowerCase()).matches();
    }
    
    public static boolean isValidCollateral(short collateral) {
        return collateral >= 1000 && collateral <= 500000;
    }
    
    public static boolean isValidexperience(String exp) {
        return !isNullOrEmpty(exp) && Experience_PATTERN.matcher(exp).matches();
    }
    
    
    public static boolean validateField(String value, boolean isCriteria) {
        return !isNullOrEmpty(value) && isCriteria;
    }
    
    public static boolean validateCollateral(String CollateralText) {
        try {
            short collateral = Short.parseShort(CollateralText.trim());
            return isValidCollateral(collateral);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
