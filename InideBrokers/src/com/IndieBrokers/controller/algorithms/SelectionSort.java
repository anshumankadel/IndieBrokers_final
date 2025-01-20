/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.IndieBrokers.controller.algorithms;

import com.IndieBrokers.model.IndieBrokersModel;
import java.util.ArrayList;
import java.util.List;

/**
 * SelectionSort class provides sorting functionality for broker records based on their IDs.
 * The sorting can be done in ascending or descending order.
 * 
 * Author: forea
 */
public class SelectionSort {
    // List to store broker records for sorting.
    List<IndieBrokersModel> BrokerSortList;
    
    // Constructor initializes an empty list to hold broker records.
    public SelectionSort(){
        BrokerSortList = new ArrayList<>();
    }

    /**
     * Sorts the provided list of brokers by their ID using the Selection Sort algorithm.
     * 
     * @param BrokersList List of brokers to be sorted.
     * @param isDesc If true, sorts in descending order; otherwise, sorts in ascending order.
     * @return Sorted list of brokers.
     * @throws IllegalArgumentException if the input list is null or empty.
     */
    public List<IndieBrokersModel> sortByBrokerID(List<IndieBrokersModel> BrokersList, boolean isDesc) {
        // Clear and copy the provided list to ensure the original list remains unchanged.
        this.BrokerSortList.clear();
        this.BrokerSortList.addAll(BrokersList);
        
        // Validate the input list to prevent processing null or empty data.
        if (BrokerSortList == null || BrokerSortList.isEmpty()) {
            throw new IllegalArgumentException("Broker list cannot be null or empty.");
        }

        // Perform Selection Sort on the broker list.
        for (int i = 0; i < BrokerSortList.size() - 1; i++) {
            // Find the index of the minimum or maximum broker ID based on sorting order.
            int extremumIndex = findExtremumIndex(BrokerSortList, i, isDesc);
            
            // Swap elements if the current index is not the extremum index.
            if (i != extremumIndex) {
                swap(BrokerSortList, i, extremumIndex);
            }
        }

        return BrokerSortList;
    }

    /**
     * Finds the index of the smallest or largest broker ID depending on sorting order.
     * 
     * @param BrokerSortList List of brokers to search.
     * @param startIndex The starting index for comparison.
     * @param isDesc If true, finds the largest ID; otherwise, finds the smallest.
     * @return Index of the extremum element in the list.
     */
    private int findExtremumIndex(List<IndieBrokersModel> BrokerSortList, int startIndex, boolean isDesc) {
        int extremumIndex = startIndex;

        // Iterate through the list to find the smallest or largest element.
        for (int j = startIndex + 1; j < BrokerSortList.size(); j++) {
            if (shouldSwap(BrokerSortList.get(j).getBrokerID(), BrokerSortList.get(extremumIndex).getBrokerID(), isDesc)) {
                extremumIndex = j;
            }
        }

        return extremumIndex;
    }

    /**
     * Determines whether elements should be swapped based on sorting order.
     * 
     * @param current Current broker ID being compared.
     * @param extremum The extremum broker ID to compare against.
     * @param isDesc If true, checks for descending order; otherwise, ascending.
     * @return True if elements should be swapped; false otherwise.
     */
    private boolean shouldSwap(int current, int extremum, boolean isDesc) {
        return isDesc ? current > extremum : current < extremum;
    }

    /**
     * Swaps two elements in the list at the specified indices.
     * 
     * @param BrokerSortList The list containing broker records.
     * @param i The index of the first element to swap.
     * @param j The index of the second element to swap.
     */
    private void swap(List<IndieBrokersModel> BrokerSortList, int i, int j) {
        IndieBrokersModel temp = BrokerSortList.get(i);
        BrokerSortList.set(i, BrokerSortList.get(j));
        BrokerSortList.set(j, temp);
    }
}
