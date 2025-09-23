package com.logic;

public class PhysicalBook extends Book{

    public PhysicalBook(int id, String name, String authorname, String year, String synopsis, String disposability, boolean type) {
        super(id, name, authorname, year, synopsis, disposability, type);
    }

    @Override
    public String csvDescriptionProduct() {
        return "";
    }


}
