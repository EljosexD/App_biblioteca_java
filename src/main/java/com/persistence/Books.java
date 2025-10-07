package com.persistence;

import com.logic.Book;
import com.logic.DigitalBook;
import com.logic.PhysicalBook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Books {
    File fileVariable = new File("database\\basedateBook.csv");
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
    public void uploadWriteFile(ArrayList<Book> uploadBook){
        try {
            FileWriter writer = new FileWriter(fileVariable, false);
            writer.write("Id,Name,authorname,year,Type,synopsis,disposability\n");
            for (Book p : uploadBook) {
                writer.write(p.csvDescriptionProduct() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
    public ArrayList<Book> downloadProductFile() {
        ArrayList<Book> bookslist = new ArrayList<>();
        try {
            FileReader read = new FileReader(fileVariable);
            BufferedReader readReader = new BufferedReader(read);
            String linea = readReader.readLine(); // Esto es importante
            while ((linea = readReader.readLine()) != null) {
                String[] datos = linea.split(",");
                int id = Integer.parseInt(datos[0]);
                String name = datos[1];
                String authorname = datos[2];
                String year = datos[3];
                String type = datos[4];
                String synopsis = datos[5];
                boolean disposability = Boolean.parseBoolean(datos[6]);

                Book BookFiles;
                switch (type) {
                    case "physical":
                        BookFiles = new PhysicalBook(id, name, authorname, year,synopsis,disposability,type);
                        break;
                    case "digital":
                        BookFiles = new DigitalBook(id, name, authorname, year,synopsis,disposability,type);
                        break;
                    default:
                        throw new IllegalArgumentException("Tipo desconocido: " + type);
                }
                bookslist.add(BookFiles);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookslist;
    }
}
