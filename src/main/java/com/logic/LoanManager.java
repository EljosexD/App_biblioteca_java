/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logic;

import java.util.ArrayList;

/**
 *
 * @author eljot
 */
public class LoanManager {
    private ArrayList<String> bookloans = new ArrayList<>();

    public void addLoan(String loan) {
        bookloans.add(loan);
    }

    public ArrayList<String> getLoans() {
        return bookloans;
    }

    public void clearLoans() {
        bookloans.clear();
    }
}