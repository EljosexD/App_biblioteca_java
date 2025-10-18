/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.igu;
import com.logic.Book;
import com.logic.PhysicalBook;
import com.logic.DigitalBook;


import javax.swing.*;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author USUARIO
 */
public class BookCrud extends javax.swing.JFrame {
    private ArrayList<Book> bibliotec = new ArrayList<>();
    private DefaultTableModel tableColumnModel;
    private final Home parentHome;
    
    public BookCrud(Home parentHome) {
        initComponents();
        this.parentHome = parentHome;
        this.bibliotec = parentHome.bibliotec;
        mostTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPBackground = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        JPoptions = new javax.swing.JPanel();
        JBadd = new javax.swing.JButton();
        JBedit = new javax.swing.JButton();
        JBdelete = new javax.swing.JButton();
        JBreturn = new javax.swing.JButton();
        JPbuho_icon = new javax.swing.JPanel();
        JLbuho_icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JPBackground.setBackground(new java.awt.Color(102, 102, 102));
        JPBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setFocusable(false);
        jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex , int colIndex){
                return false;
            }
        };
        jScrollPane1.setViewportView(jTable1);

        JPBackground.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1000, 410));

        JPoptions.setBackground(new java.awt.Color(0, 0, 0));

        JBadd.setBackground(new java.awt.Color(245, 245, 245));
        JBadd.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        JBadd.setText("Add");
        JBadd.setBorderPainted(false);
        JBadd.setFocusPainted(false);
        JBadd.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                JBaddMouseMoved(evt);
            }
        });
        JBadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JBaddMouseExited(evt);
            }
        });
        JBadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBaddActionPerformed(evt);
            }
        });

        JBedit.setBackground(new java.awt.Color(245, 245, 245));
        JBedit.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        JBedit.setText("Edit");
        JBedit.setBorderPainted(false);
        JBedit.setFocusPainted(false);
        JBedit.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                JBeditMouseMoved(evt);
            }
        });
        JBedit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JBeditMouseExited(evt);
            }
        });
        JBedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBeditActionPerformed(evt);
            }
        });

        JBdelete.setBackground(new java.awt.Color(245, 245, 245));
        JBdelete.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        JBdelete.setText("Delete");
        JBdelete.setBorderPainted(false);
        JBdelete.setFocusPainted(false);
        JBdelete.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                JBdeleteMouseMoved(evt);
            }
        });
        JBdelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JBdeleteMouseExited(evt);
            }
        });
        JBdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBdeleteActionPerformed(evt);
            }
        });

        JBreturn.setBackground(new java.awt.Color(245, 245, 245));
        JBreturn.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        JBreturn.setText("Return");
        JBreturn.setBorderPainted(false);
        JBreturn.setFocusPainted(false);
        JBreturn.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                JBreturnMouseMoved(evt);
            }
        });
        JBreturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JBreturnMouseExited(evt);
            }
        });
        JBreturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBreturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPoptionsLayout = new javax.swing.GroupLayout(JPoptions);
        JPoptions.setLayout(JPoptionsLayout);
        JPoptionsLayout.setHorizontalGroup(
            JPoptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPoptionsLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(JBadd, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(JBedit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(JBdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 338, Short.MAX_VALUE)
                .addComponent(JBreturn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        JPoptionsLayout.setVerticalGroup(
            JPoptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPoptionsLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(JPoptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBadd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBedit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBreturn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        JPBackground.add(JPoptions, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 1000, 60));

        JPbuho_icon.setBackground(new java.awt.Color(0, 0, 0));

        JLbuho_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Buho-creado-luna.png"))); // NOI18N

        javax.swing.GroupLayout JPbuho_iconLayout = new javax.swing.GroupLayout(JPbuho_icon);
        JPbuho_icon.setLayout(JPbuho_iconLayout);
        JPbuho_iconLayout.setHorizontalGroup(
            JPbuho_iconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPbuho_iconLayout.createSequentialGroup()
                .addContainerGap(442, Short.MAX_VALUE)
                .addComponent(JLbuho_icon)
                .addGap(430, 430, 430))
        );
        JPbuho_iconLayout.setVerticalGroup(
            JPbuho_iconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPbuho_iconLayout.createSequentialGroup()
                .addComponent(JLbuho_icon)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        JPBackground.add(JPbuho_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 130));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
 
    public ArrayList<Book> getListbook(){
        return bibliotec;
    }
    
   public void setListbook(ArrayList books){
        this.bibliotec = books;
        mostTable();
    } 
    
    private void mostTable(){
        tableColumnModel = new DefaultTableModel();

        tableColumnModel.addColumn("Id");
        tableColumnModel.addColumn("Name");
        tableColumnModel.addColumn("Author name");
        tableColumnModel.addColumn("Year");
        tableColumnModel.addColumn("Type");
        tableColumnModel.addColumn("Synopsis");
        tableColumnModel.addColumn("Disposability");

        this.jTable1.setModel(tableColumnModel);
    
        String [] date = new String[7];
        for(Book book : bibliotec){
                date [0] = String.valueOf(book.getId());
                date [1] = book.getName();
                date [2] = book.getAuthorname();
                date [3] = book.getYear();
                date [4] = book.getType();
                date [5] = book.getSynopsis();
                date [6] = String.valueOf(book.isDisposability());
                tableColumnModel.addRow(date);
            
        }
    }
    private void JBreturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBreturnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        parentHome.setVisible(true);
    }//GEN-LAST:event_JBreturnActionPerformed

    private void JBaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBaddActionPerformed
        // TODO add your handling code here:
        try {
    // Pedir ID y validar duplicados
    String idStr = JOptionPane.showInputDialog(this, "ID:");
    if (idStr == null || idStr.trim().isEmpty()) return; // usuario canceló o dejó vacío
    int id = Integer.parseInt(idStr.trim());

    // Verificar si ya existe un libro con ese ID
    boolean exists = false;
    for (Book existing : bibliotec) {
        if (existing.getId() == id) {
            exists = true;
            break;
        }
    }
    if (exists) {
        JOptionPane.showMessageDialog(this, "A book with the ID already exists " + id);
        return;
    }

    // Pedir el resto de los datos
    String name = JOptionPane.showInputDialog(this, "Name:");
    if (name == null || name.trim().isEmpty()) return;

    String author = JOptionPane.showInputDialog(this, "Author:");
    if (author == null) author = "";

    String year = JOptionPane.showInputDialog(this, "Year:");
    if (year == null) year = "";

    String synopsis = JOptionPane.showInputDialog(this, "Synopsis:");
    if (synopsis == null) synopsis = "";

    String[] types = {"physical", "digital"};
    Object sel = JOptionPane.showInputDialog(this, "Type:", "Type", JOptionPane.QUESTION_MESSAGE, null, types, types[0]);
    if (sel == null) return;
    String type = sel.toString();

    int dispo = JOptionPane.showConfirmDialog(this, "Available?", "Availability", JOptionPane.YES_NO_OPTION);
    boolean available = dispo == JOptionPane.YES_OPTION;

    // Crear objeto Book
    Book b = "physical".equalsIgnoreCase(type)
            ? new PhysicalBook(id, name, author, year, synopsis, available, type)
            : new DigitalBook(id, name, author, year, synopsis, available, type);

    // Agregar a la lista
    bibliotec.add(b);

    // Agregar fila a la tabla
    String[] data = new String[7];
    data[0] = String.valueOf(b.getId());
    data[1] = b.getName();
    data[2] = b.getAuthorname();
    data[3] = b.getYear();
    data[4] = b.getType(); 
    data[5] = b.getSynopsis();
    data[6] = String.valueOf(b.isDisposability());

    tableColumnModel.addRow(data);

} catch (Exception ex) {
    JOptionPane.showMessageDialog(this, "Error adding book: " + ex.getMessage());
}
    }//GEN-LAST:event_JBaddActionPerformed

    private void JBeditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBeditActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRow() < 0 ){
            JOptionPane.showMessageDialog(this, "Select a row to edit.");
        }
        Book b = bibliotec.get(jTable1.getSelectedRow());
        String idStr = JOptionPane.showInputDialog(this, "ID:");
        int id = Integer.parseInt(idStr.trim());
         String name = JOptionPane.showInputDialog(this, "Name:");
    if (name == null || name.trim().isEmpty()) return;

    String author = JOptionPane.showInputDialog(this, "Author:");
    if (author == null) author = "";

    String year = JOptionPane.showInputDialog(this, "Year:");
    if (year == null) year = "";

    String synopsis = JOptionPane.showInputDialog(this, "Synopsis:");
    if (synopsis == null) synopsis = "";

    String[] types = {"physical", "digital"};
    Object sel = JOptionPane.showInputDialog(this, "Type:", "Type", JOptionPane.QUESTION_MESSAGE, null, types, types[0]);
    if (sel == null) return;
    String type = sel.toString();

    int dispo = JOptionPane.showConfirmDialog(this, "Available?", "Availability", JOptionPane.YES_NO_OPTION);
    boolean available = dispo == JOptionPane.YES_OPTION;
    
    for (Book books : bibliotec) {
        if (books == b) {
            books.setId(id);
            books.setName(name);
            books.setAuthorname(author);
            books.setYear(year);
            books.setSynopsis(synopsis);
            books.setType(type);
            books.setDisposability(available);
        }
    }
     mostTable();
    }//GEN-LAST:event_JBeditActionPerformed

    private void JBdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBdeleteActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        if(jTable1.getSelectedRow() < 0 ){
            JOptionPane.showMessageDialog(this, "Select a row to edit.");
        }
        String StringBook = String.valueOf(tableColumnModel.getValueAt(row, 0));
        int idBook = Integer.parseInt(StringBook);
        for (Book book : bibliotec){
            if(idBook == book.getId()){
                book.setDisposability(true);
                bibliotec.removeIf(b -> b.getId() == idBook);
                tableColumnModel.removeRow(row);
                JOptionPane.showMessageDialog(null, "The book was deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }
    }//GEN-LAST:event_JBdeleteActionPerformed

    private void JBaddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBaddMouseExited
        // TODO add your handling code here:
        JBadd.setBackground(new java.awt.Color(245, 245, 245)); 
        JBadd.setForeground(new java.awt.Color(28, 28, 28));  
    }//GEN-LAST:event_JBaddMouseExited

    private void JBaddMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBaddMouseMoved
        // TODO add your handling code here:
        JBadd.setBackground(new java.awt.Color(54, 52, 52));
        JBadd.setForeground(new java.awt.Color(245, 245, 245));
    }//GEN-LAST:event_JBaddMouseMoved

    private void JBeditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBeditMouseExited
        // TODO add your handling code here:
        JBedit.setBackground(new java.awt.Color(245, 245, 245)); 
        JBedit.setForeground(new java.awt.Color(28, 28, 28));  
    }//GEN-LAST:event_JBeditMouseExited

    private void JBeditMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBeditMouseMoved
        // TODO add your handling code here:
        JBedit.setBackground(new java.awt.Color(54, 52, 52));
        JBedit.setForeground(new java.awt.Color(245, 245, 245));
    }//GEN-LAST:event_JBeditMouseMoved

    private void JBdeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBdeleteMouseExited
        // TODO add your handling code here:
        JBdelete.setBackground(new java.awt.Color(245, 245, 245)); 
        JBdelete.setForeground(new java.awt.Color(28, 28, 28));  
    }//GEN-LAST:event_JBdeleteMouseExited

    private void JBdeleteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBdeleteMouseMoved
        // TODO add your handling code here:
        JBdelete.setBackground(new java.awt.Color(54, 52, 52));
        JBdelete.setForeground(new java.awt.Color(245, 245, 245));
    }//GEN-LAST:event_JBdeleteMouseMoved

    private void JBreturnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBreturnMouseExited
        // TODO add your handling code here:
        JBreturn.setBackground(new java.awt.Color(245, 245, 245)); 
        JBreturn.setForeground(new java.awt.Color(28, 28, 28));  
    }//GEN-LAST:event_JBreturnMouseExited

    private void JBreturnMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBreturnMouseMoved
        // TODO add your handling code here:
        JBreturn.setBackground(new java.awt.Color(54, 52, 52));
        JBreturn.setForeground(new java.awt.Color(245, 245, 245));
    }//GEN-LAST:event_JBreturnMouseMoved

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBadd;
    private javax.swing.JButton JBdelete;
    private javax.swing.JButton JBedit;
    private javax.swing.JButton JBreturn;
    private javax.swing.JLabel JLbuho_icon;
    private javax.swing.JPanel JPBackground;
    private javax.swing.JPanel JPbuho_icon;
    private javax.swing.JPanel JPoptions;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
