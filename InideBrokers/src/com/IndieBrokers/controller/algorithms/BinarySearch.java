package com.IndieBrokers.controller.algorithms;

import com.IndieBrokers.model.IndieBrokersModel;
import java.util.List;

public class BinarySearch {
    
    public BinarySearch() {
    }
    
    public IndieBrokersModel searchByBrokerName(List<IndieBrokersModel> BrokersList, String targetName) {
        int left = 0, right = BrokersList.size() - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            IndieBrokersModel midBroker = BrokersList.get(mid);
            
            
            int comparison = midBroker.getBrokername().compareTo(targetName);
            
            if (comparison == 0) {
                return midBroker; // Broker found
            } else if (comparison < 0) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        
        return null; // Broker not found
    }
}
