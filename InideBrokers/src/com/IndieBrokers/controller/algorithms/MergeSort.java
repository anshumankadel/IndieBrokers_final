package com.IndieBrokers.controller.algorithms;

import com.IndieBrokers.model.IndieBrokersModel;
import java.util.List;
import java.util.ArrayList;

/**
 * MergeSort class to sort a list of IndieBrokersModel based on collateral values.
 * Provides sorting in both ascending and descending order.
 */
public class MergeSort {
    
    /**
     * Sorts the given list of brokers by collateral in ascending order.
     * @param BrokersList List of IndieBrokersModel objects.
     * @return Sorted list in ascending order.
     */
    public List<IndieBrokersModel> sortbycollateralAscending(List<IndieBrokersModel> BrokersList) {
        return mergeSort(BrokersList, true); 
    }
    
    /**
     * Sorts the given list of brokers by collateral in descending order.
     * @param BrokersList List of IndieBrokersModel objects.
     * @return Sorted list in descending order.
     */
    public List<IndieBrokersModel> sortbycollateralDescending(List<IndieBrokersModel> BrokersList) {
        return mergeSort(BrokersList, false); 
    }
    
    /**
     * Recursively splits the list into halves and merges them in sorted order.
     * @param BrokersList The list to be sorted.
     * @param ascending Boolean flag for sorting order (true for ascending, false for descending).
     * @return Sorted list of IndieBrokersModel.
     */
    private List<IndieBrokersModel> mergeSort(List<IndieBrokersModel> BrokersList, boolean ascending) {
        if (BrokersList.size() <= 1) {
            return BrokersList; // Base case: A list of size 1 is already sorted.
        }
        
        // Finding the middle index of the list
        int middle = BrokersList.size() / 2;
        
        // Splitting the list into two halves
        List<IndieBrokersModel> baya = new ArrayList<>(BrokersList.subList(0, middle));
        List<IndieBrokersModel> daya = new ArrayList<>(BrokersList.subList(middle, BrokersList.size()));
        
        // Recursively sort both halves
        baya = mergeSort(baya, ascending);
        daya = mergeSort(daya, ascending);
        
        // Merging the sorted halves
        return merge(baya, daya, ascending);
    }
    
    /**
     * Merges two sorted lists into a single sorted list.
     * @param baya First sorted sublist.
     * @param daya Second sorted sublist.
     * @param ascending Boolean flag for sorting order.
     * @return Merged sorted list.
     */
    private List<IndieBrokersModel> merge(List<IndieBrokersModel> baya, List<IndieBrokersModel> daya, boolean ascending) {
        List<IndieBrokersModel> merged = new ArrayList<>();
        int i = 0, j = 0;
        
        // Merging elements in sorted order
        while (i < baya.size() && j < daya.size()) {
            if (shouldMergebaya(baya.get(i), daya.get(j), ascending)) {
                merged.add(baya.get(i));
                i++;
            } else {
                merged.add(daya.get(j));
                j++;
            }
        }
        
        // Adding remaining elements from baya if any
        while (i < baya.size()) {
            merged.add(baya.get(i));
            i++;
        }
        
        // Adding remaining elements from daya if any
        while (j < daya.size()) {
            merged.add(daya.get(j));
            j++;
        }
        
        return merged;
    }
    
    
    /**
     * Compares two IndieBrokersModel objects based on their collateral.
     * @param bayaale Element from the first sublist.
     * @param dayaale Element from the second sublist.
     * @param ascending Boolean flag for sorting order.
     * @return True if bayaale should be placed before dayaale, otherwise false.
     */
    private boolean shouldMergebaya(IndieBrokersModel bayaale, IndieBrokersModel dayaale, boolean ascending) {
        return ascending ? bayaale.getCollateral() <= dayaale.getCollateral()
                         : bayaale.getCollateral() > dayaale.getCollateral();
    }
}
