
package com.igu;

import com.logic.Book;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * TableModel simple para exponer una lista de {@link Book} en un JTable.
 * Las celdas son editables (excepto el id y el tipo). Cuando una celda se
 * edita, este modelo notificará opcionalmente al {@link Bookcontroller}
 * (si se le proporcionó) llamando a controller.update(book).
 */
public class BookTableModel extends AbstractTableModel {

    private final List<Book> data;
    private final String[] columns = new String[]{"Id", "Name", "Author", "Year", "Synopsis", "Available", "Type"};
    private Bookcontroller controller; // opcional, para notificar actualizaciones

    public BookTableModel() {
        this.data = new ArrayList<>();
    }

    public BookTableModel(Bookcontroller controller) {
        this();
        this.controller = controller;
    }

    public void setController(Bookcontroller controller) {
        this.controller = controller;
    }

    public void setData(List<Book> books) {
        data.clear();
        if (books != null) data.addAll(books);
        fireTableDataChanged();
    }

    public Book getRow(int row) {
        return data.get(row);
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book b = data.get(rowIndex);
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

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // permitir edición salvo en id (0) y type (6)
        return columnIndex != 0 && columnIndex != 6;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Book b = data.get(rowIndex);
        switch (columnIndex) {
            case 1: b.setName((String) aValue); break;
            case 2: b.setAuthorname((String) aValue); break;
            case 3: b.setYear((String) aValue); break;
            case 4: b.setSynopsis((String) aValue); break;
            case 5:
                if (aValue instanceof Boolean) b.setDisposability((Boolean) aValue);
                else b.setDisposability(Boolean.parseBoolean(String.valueOf(aValue)));
                break;
            default: break;
        }
        // Notificar la actualización al controlador (si existe)
        if (controller != null) {
            try {
                controller.update(b);
            } catch (Exception ex) {
                // no lanzar desde el modelo; simplemente loggear o ignorar
                System.err.println("Warning: failed to update book in controller: " + ex.getMessage());
            }
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

}
