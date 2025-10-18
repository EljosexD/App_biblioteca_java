/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.igu;

import com.logic.Book;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author eljot
 */
public class BookLoanPageLoan extends javax.swing.JPanel {
    private DefaultTableModel tableColumnModel;
    private ArrayList<Book> bibliotec = new ArrayList<>();
    private final BookLoan parentFrame;

    public BookLoanPageLoan(BookLoan parentFrame) {
        initComponents();
        this.parentFrame = parentFrame;
        
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPbackground = new javax.swing.JPanel();
        JPtitle = new javax.swing.JPanel();
        JLtitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        JLtext_button = new javax.swing.JLabel();
        JBloans = new javax.swing.JButton();

        JPbackground.setBackground(new java.awt.Color(0, 0, 0));
        JPbackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JPtitle.setBackground(new java.awt.Color(51, 51, 51));

        JLtitle.setFont(new java.awt.Font("Roboto Light", 2, 36)); // NOI18N
        JLtitle.setForeground(new java.awt.Color(255, 255, 255));
        JLtitle.setText("Owl book loans");

        javax.swing.GroupLayout JPtitleLayout = new javax.swing.GroupLayout(JPtitle);
        JPtitle.setLayout(JPtitleLayout);
        JPtitleLayout.setHorizontalGroup(
            JPtitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPtitleLayout.createSequentialGroup()
                .addContainerGap(294, Short.MAX_VALUE)
                .addComponent(JLtitle)
                .addGap(280, 280, 280))
        );
        JPtitleLayout.setVerticalGroup(
            JPtitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPtitleLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(JLtitle)
                .addGap(17, 17, 17))
        );

        JPbackground.add(JPtitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 80));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
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
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        JPbackground.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 810, 390));

        JLtext_button.setFont(new java.awt.Font("Roboto Condensed Light", 2, 24)); // NOI18N
        JLtext_button.setForeground(new java.awt.Color(255, 255, 255));
        JLtext_button.setText("Select the book and press the button");
        JPbackground.add(JLtext_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, -1, -1));

        JBloans.setBackground(new java.awt.Color(245, 245, 245));
        JBloans.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        JBloans.setText("Loans");
        JBloans.setBorderPainted(false);
        JBloans.setFocusPainted(false);
        JBloans.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                JBloansMouseMoved(evt);
            }
        });
        JBloans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JBloansMouseExited(evt);
            }
        });
        JBloans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBloansActionPerformed(evt);
            }
        });
        JPbackground.add(JBloans, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 540, 200, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPbackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPbackground, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JBloansMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBloansMouseMoved
        // TODO add your handling code here:
        JBloans.setBackground(new java.awt.Color(54, 52, 52));
        JBloans.setForeground(new java.awt.Color(245, 245, 245));
    }//GEN-LAST:event_JBloansMouseMoved

    private void JBloansMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBloansMouseExited
        // TODO add your handling code here:
        JBloans.setBackground(new java.awt.Color(245, 245, 245));
        JBloans.setForeground(new java.awt.Color(28, 28, 28));
    }//GEN-LAST:event_JBloansMouseExited

    private void JBloansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBloansActionPerformed
        // TODO add your handling code here:
         int row = jTable1.getSelectedRow();
        String StringBook = String.valueOf(tableColumnModel.getValueAt(row, 0));
        int idBook = Integer.parseInt(StringBook);
        if(tableColumnModel.getValueAt(row, 6).equals("true")){
            tableColumnModel.setValueAt("false", row, 6);
            tableColumnModel.fireTableDataChanged();
            for (Book book : bibliotec){
                if(idBook == book.getId()){
                    book.setDisposability(false);
                    parentFrame.getBibliotecLoan().add(book);
                    break;
                }
            }
            parentFrame.setListbook(bibliotec);
        }else{
            JOptionPane.showMessageDialog(null, "The selected book is not available for loan", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_JBloansActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBloans;
    private javax.swing.JLabel JLtext_button;
    private javax.swing.JLabel JLtitle;
    private javax.swing.JPanel JPbackground;
    private javax.swing.JPanel JPtitle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
