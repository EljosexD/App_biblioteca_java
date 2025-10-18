package com.igu;

import com.logic.Book;
import com.logic.PhysicalBook;
import com.logic.DigitalBook;
import com.logic.Bookcontroller;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

import java.util.ArrayList;

/**
 * Interfaz de control para la biblioteca.
 *
 * Esta clase proporciona una ventana Swing sencilla para gestionar libros:
 * - Muestra los libros en una JTable usando BookTableModel
 * - Permite añadir, editar y borrar libros (diálogos simples)
 * - Permite cargar y guardar la lista mediante Bookcontroller (que a su vez usa la persistencia CSV)
 *
 * Comentarios en español añadidos para facilitar el entendimiento del código.
 */
public class ControlsInterface extends JFrame {

    // Controlador que encapsula la lógica de negocio (lista en memoria y persistencia).
    // Bookcontroller fue ubicado en el paquete com.logic para separar lógica de UI.
    private final Bookcontroller controller = new Bookcontroller();

    // Modelo de tabla que adapta List<Book> a la JTable.
    private final BookTableModel tableModel = new BookTableModel();

    // Referencia opcional a la ventana padre (Home) si se desea interactuar con ella
    private Home parentFrame;


    public ControlsInterface(Home parentFrame) {
        super("Controls Interface - Biblioteca");
        initUI();
        this.parentFrame = parentFrame;
    }

    // Inicializa los componentes gráficos y la disposición de la ventana.
    // Crea la tabla, los botones y conecta los listeners.
    private void initUI() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 500);
        setLocationRelativeTo(null);

    
        // Tabla que muestra los datos del modelo tableModel.
    JTable table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(table);

    // Panel con botones para las acciones CRUD y persistencia.
    JPanel buttons = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton addBtn = new JButton("Add");
        JButton editBtn = new JButton("Edit");
        JButton delBtn = new JButton("Delete");
        JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    // Botón de salida
    JButton exitBtn = new JButton("Exit");

        buttons.add(addBtn);
        buttons.add(editBtn);
        buttons.add(delBtn);
        buttons.add(loadBtn);
        buttons.add(saveBtn);
    buttons.add(exitBtn);

        add(scroll, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);

    // Asociar acciones a los botones: cada listener llama al método correspondiente.
    // Se pasan índices/selecciones cuando es necesario (por ejemplo table.getSelectedRow()).
    addBtn.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent e) { onAdd(); }});
    editBtn.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent e) { onEdit(table.getSelectedRow()); }});
    delBtn.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent e) { onDelete(table.getSelectedRow()); }});
    saveBtn.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent e) { onSave(); }});
    exitBtn.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent e) {
        // Antes de cerrar, pasar la lista actual al formulario padre usando sus setters
        if (parentFrame != null) {
            // controller.list() devuelve ArrayList<Book>
            parentFrame.setListbook(controller.list());
            // Si se quiere también pasar una lista de préstamos, se podría llamar a
            // parentFrame.setListbookLoan(...)
            parentFrame.setVisible(true);
        }
        // Cierra esta ventana
        dispose();
    }});

        // Intentamos cargar datos existentes al iniciar la ventana (no crítico).
        
    }

    public void setBooks(ArrayList<Book> books) {
        // Reemplaza de forma segura el contenido del controlador por la lista recibida.
        // Primero eliminamos los libros actualmente en el controlador (iterando sobre una copia),
        // luego añadimos los nuevos y actualizamos la vista.
        ArrayList<Book> current = controller.list();
        for (Book b : current) {
            controller.removeById(b.getId());
        }
        if (books != null) {
            for (Book b : books) {
                // add() asignará id si es necesario
                controller.add(b);
            }
        }
        // Refrescar la JTable
        tableModel.setData(controller.list());
    }

    private void onAdd() {
        // Añadir un nuevo libro mediante diálogos simples.
        // Flujo:
        // 1) Pedir los campos básicos al usuario (nombre, autor, año, sinopsis, tipo)
        // 2) Crear una instancia de PhysicalBook o DigitalBook según el tipo
        // 3) Delegar en el controlador (controller.add) para que asigne id y guarde en memoria
        // 4) Actualizar la vista (tableModel.setData) para refrescar la JTable

        try {
            String name = JOptionPane.showInputDialog(this, "Name:");
            if (name == null || name.trim().isEmpty()) return; // usuario canceló o vacío
            String author = JOptionPane.showInputDialog(this, "Author:"); if (author == null) author = "";
            String year = JOptionPane.showInputDialog(this, "Year:"); if (year == null) year = "";
            String synopsis = JOptionPane.showInputDialog(this, "Synopsis:"); if (synopsis == null) synopsis = "";
            String[] types = new String[]{"physical","digital"};
            Object sel = JOptionPane.showInputDialog(this, "Type:", "Type", JOptionPane.QUESTION_MESSAGE, null, types, types[0]);
            if (sel == null) return; String type = sel.toString();
            int dispo = JOptionPane.showConfirmDialog(this, "Available?", "Availability", JOptionPane.YES_NO_OPTION);
            boolean available = dispo == JOptionPane.YES_OPTION;

            // Crear la entidad Book apropiada y delegar en el controlador.
            Book b = "physical".equalsIgnoreCase(type)
                    ? new PhysicalBook(0, name, author, year, synopsis, available, "physical")
                    : new DigitalBook(0, name, author, year, synopsis, available, "digital");
            controller.add(b);
            // Refrescar la tabla mostrando la lista actualizada desde el controlador.
            tableModel.setData(controller.list());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error adding book: "+ex.getMessage());
        }
    }

    private void onEdit(int selectedRow) {
    // Editar libro seleccionado.
    // 1) Obtener la lista desde el controlador y validar el índice seleccionado
    // 2) Mostrar diálogos precargados con los valores actuales y permitir cambios
    // 3) Actualizar el objeto Book y delegar en controller.update(book)
    // 4) Refrescar la tabla con los datos actualizados
    java.util.List<Book> current = controller.list();
    if (selectedRow < 0 || selectedRow >= current.size()) { JOptionPane.showMessageDialog(this, "Select a row to edit."); return; }
    Book b = current.get(selectedRow);
        try {
            String name = JOptionPane.showInputDialog(this, "Name:", b.getName()); if (name == null) return; b.setName(name);
            String author = JOptionPane.showInputDialog(this, "Author:", b.getAuthorname()); if (author != null) b.setAuthorname(author);
            String year = JOptionPane.showInputDialog(this, "Year:", b.getYear()); if (year != null) b.setYear(year);
            String synopsis = JOptionPane.showInputDialog(this, "Synopsis:", b.getSynopsis()); if (synopsis != null) b.setSynopsis(synopsis);
            int dispo = JOptionPane.showConfirmDialog(this, "Available?", "Availability", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
            // Se actualiza la disponibilidad según la respuesta del usuario
            b.setDisposability(dispo == JOptionPane.YES_OPTION);
            controller.update(b);
            tableModel.setData(controller.list());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error editing book: "+ex.getMessage());
        }
    }

    private void onDelete(int selectedRow) {
    // Eliminar el libro seleccionado tras confirmación del usuario.
    java.util.List<Book> current = controller.list();
    if (selectedRow < 0 || selectedRow >= current.size()) { JOptionPane.showMessageDialog(this, "Select a row to delete."); return; }
    Book b = current.get(selectedRow);
        int conf = JOptionPane.showConfirmDialog(this, "Delete '"+b.getName()+"'?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (conf == JOptionPane.YES_OPTION) {
            controller.removeById(b.getId());
            tableModel.setData(controller.list());
        }
    }

   

    private void onSave() {
        // Guardar la lista actual mediante el controlador (persistencia CSV).
        try {
            controller.save();
            JOptionPane.showMessageDialog(this, "Saved "+controller.list().size()+" books.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error saving: "+ex.getMessage());
        }
    }

    /**
     * Getter público que devuelve la lista actual de libros como ArrayList.
     * Se devuelve una copia defensiva para no exponer la colección interna.
     */
    public ArrayList<Book> getBooks() {
        return new ArrayList<Book>(controller.list());
    }

    // ---- Modelo de tabla simple ----
    // Adapta una List<Book> para que la JTable pueda mostrar las columnas deseadas.
    private static class BookTableModel extends AbstractTableModel {
        // Encabezados de columna visibles en la JTable
        private final String[] cols = new String[]{"Id","Name","Author","Year","Synopsis","Available","Type"};
        // Filas en memoria (copia de la lista que provee el controlador)
        private java.util.List<Book> rows = new ArrayList<>();

        // Reemplaza los datos del modelo y notifica a la vista para refrescarse
        void setData(java.util.List<Book> list) { this.rows = new ArrayList<>(list); fireTableDataChanged(); }

        @Override public int getRowCount() { return rows.size(); }
        @Override public int getColumnCount() { return cols.length; }
        @Override public String getColumnName(int col) { return cols[col]; }

        // Devuelve el valor de la celda en función de la columna solicitada
        @Override public Object getValueAt(int rowIndex, int columnIndex) {
            Book b = rows.get(rowIndex);
            switch (columnIndex) {
                case 0: return b.getId();
                case 1: return b.getName();
                case 2: return b.getAuthorname();
                case 3: return b.getYear();
                case 4: return b.getSynopsis();
                case 5: return b.isDisposability();
                case 6: return b.getType();
                default: return null;
            }
        }
    }

    // small helper to run the UI standalone
   
}
