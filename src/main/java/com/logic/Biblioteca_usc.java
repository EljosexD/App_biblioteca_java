/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.logic;

import com.igu.Home;
import com.persistence.Books;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eljot
 */
public class Biblioteca_usc {

    public static void main(String[] args) {
        Books persitenceBook = new Books();
        List<Book> listbook = new ArrayList<>();
        persitenceBook.CreateFile();
        System.out.println("xd");
        for (Book p : listbook){
            p.descripcionPrueba();
        }
       listbook = persitenceBook.downloadProductFile();
        for (Book p : listbook){
            p.descripcionPrueba();
        }
        System.out.println("sou sou");
        Home home = new Home();
        home.setVisible(true);
        home.setLocationRelativeTo(null);
        System.out.println("Hello World!");
        Books books = new Books();
        books.CreateFile();

    }
}
