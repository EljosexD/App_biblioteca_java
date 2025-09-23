package com.logic;

public abstract class Book {
    int id;
    String name;
    String authorname;
    String year;
    String synopsis;
    boolean disposability;
    String type;

    public Book(int id, String name, String authorname, String year, String synopsis, boolean disposability, String type) {
        this.id = id;
        this.name = name;
        this.authorname = authorname;
        this.year = year;
        this.synopsis = synopsis;
        this.disposability = disposability;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public boolean isDisposability() {
        return disposability;
    }

    public void setDisposability(boolean disposability) {
        this.disposability = disposability;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract String csvDescriptionProduct();
    public abstract void descripcionPrueba();

}
