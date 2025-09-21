package com.logic;

public abstract class Book {
    int id;
    String name;
    String authorname;
    String year;
    String synopsis;
    boolean disposability;
    public abstract String csvDescriptionProduct();
}
