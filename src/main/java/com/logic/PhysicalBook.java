package com.logic;

public class PhysicalBook extends Book{

    public PhysicalBook(int id, String name, String authorname, String year, String synopsis, boolean disposability, String type) {
        super(id, name, authorname, year, synopsis, disposability, type);
    }

    @Override
    public String csvDescriptionProduct() {
        return (this.id + "," + this.name + "," + this.authorname + "," + year + "," + this.synopsis + "," + this.disposability + "," + this.type);
    }
    public void descripcionPrueba() {
        System.out.println(
                this.id + "," +
                        this.name + "," +
                        this.authorname + "," +
                        this.year + "," +
                        this.synopsis + "," +
                        this.disposability + "," +
                        this.type
        );
    }

}
