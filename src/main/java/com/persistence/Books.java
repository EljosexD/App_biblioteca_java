package com.persistence;

import com.logic.Book;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Books {
    File fileVariable = new File("database\\basedate.csv");
    public void CreateFile() {
        try {
            if (this.fileVariable.createNewFile()){
                FileWriter writer = new FileWriter(fileVariable,true);
                writer.write("Id,Name,authorname,year,Type,synopsis,disposability\n");
                writer.close();
                System.out.println("Create your databases");
            }else {
                System.out.println("Detected file : " + fileVariable.getName());
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
    public void uploadWriteFile(List<Book> uploadBook){
        try {
            FileWriter writer = new FileWriter(fileVariable, false);
            writer.write("Id,Name,Price,Amount,Type,SpecialAttribute\n");
            for (Book p : uploadBook) {
                writer.write(p.csvDescriptionProduct() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
