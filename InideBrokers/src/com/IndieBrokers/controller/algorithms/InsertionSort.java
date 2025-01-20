/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.IndieBrokers.controller.algorithms;

import com.IndieBrokers.model.IndieBrokersModel;
import java.util.List;

/**
 * InsertionSort class provides functionality to sort a list of brokers alphabetically 
 * or in reverse alphabetical order based on their names using the Insertion Sort algorithm.
 *
 * Author: forea
 */
public class InsertionSort {
    
    // Default constructor
    public InsertionSort() {
        // No initialization needed as the sorting is performed directly on the provided list.
    }
    
    /**
     * Sorts the list of brokers alphabetically (A-Z) based on broker names.
     * 
     * @param BrokersList The list of brokers to be sorted.
     * @return The sorted list in ascending alphabetical order.
     */
    public List<IndieBrokersModel> sortAlphabetically(List<IndieBrokersModel> BrokersList) {
        return sort(BrokersList, true);
    }
    
    /**
     * Sorts the list of brokers in reverse alphabetical order (Z-A) based on broker names.
     * 
     * @param BrokersList The list of brokers to be sorted.
     * @return The sorted list in descending alphabetical order.
     */
    public List<IndieBrokersModel> sortReverseAlphabetically(List<IndieBrokersModel> BrokersList) {
        return sort(BrokersList, false);
    }
    
    /**
     * Sorts the list of brokers using the Insertion Sort algorithm.
     * 
     * @param BrokersList The list of brokers to be sorted.
     * @param ascending If true, sorts in ascending order; otherwise, sorts in descending order.
     * @return The sorted list of brokers.
     */
    private List<IndieBrokersModel> sort(List<IndieBrokersModel> BrokersList, boolean ascending) {
        for (int i = 1; i < BrokersList.size(); i++) {
            IndieBrokersModel key = BrokersList.get(i);
            int insertPosition = findInsertPosition(BrokersList, key, i, ascending);
            shiftRight(BrokersList, insertPosition, i);
            BrokersList.set(insertPosition, key);
        }
        return BrokersList;
    }
    
    /**
     * Finds the correct position to insert the current element in the sorted part of the list.
     * 
     * @param BrokersList The list of brokers being sorted.
     * @param key The current broker model to insert.
     * @param endIndex The last sorted index in the list.
     * @param ascending If true, finds position for ascending order; otherwise, descending.
     * @return The index where the element should be inserted.
     */
    private int findInsertPosition(List<IndieBrokersModel> BrokersList, IndieBrokersModel key, int endIndex, boolean ascending) {
        int j = endIndex - 1;
        // Find the position where the key should be inserted based on sorting order.
        while (j >= 0 && shouldSwap(BrokersList.get(j), key, ascending)) {
            j--;
        }
        return j + 1; // Return the appropriate insert position.
    }
    
    /**
     * Determines if two elements should be swapped based on sorting order.
     * 
     * @param a First broker to compare.
     * @param b Second broker to compare.
     * @param ascending If true, compares for ascending order; otherwise, descending.
     * @return True if elements should be swapped; false otherwise.
     */
    private boolean shouldSwap(IndieBrokersModel a, IndieBrokersModel b, boolean ascending) {
        int comparison = a.getBrokername().compareTo(b.getBrokername());
        return ascending ? comparison > 0 : comparison < 0;
    }

    /**
     * Shifts elements to the right to create space for the insertion.
     * 
     * @param BrokersList The list of brokers being sorted.
     * @param start The starting index to begin shifting.
     * @param end The ending index where the shift should stop.
     */
    private void shiftRight(List<IndieBrokersModel> BrokersList, int start, int end) {
        // Ensure that the start index is within bounds and valid for shifting.
        if (start >= 0 && end < BrokersList.size() && start < end) {
            for (int k = end; k > start; k--) {
                BrokersList.set(k, BrokersList.get(k - 1));
            }
        }
    }
}
