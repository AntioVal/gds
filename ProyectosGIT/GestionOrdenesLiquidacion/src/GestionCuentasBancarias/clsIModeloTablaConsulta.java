/*
 * clsIModeloTablaConsulta.java
 *
 * Created on 8 de octubre de 2010, 07:00 PM
 */
package GestionCuentasBancarias;

/**
 *
 * @author  sistem18
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import javax.swing.event.*;

public class clsIModeloTablaConsulta extends AbstractTableModel {

    private Vector Fila = null;
    private int num_column = 0;
    private String[] Encabezados;

    public clsIModeloTablaConsulta() {
    }

    public clsIModeloTablaConsulta(String[] Enc, int num_colum) {
        this.Encabezados = Enc;
        Fila = new Vector();
        this.num_column = num_colum;
    }

    public void setEncabezado(String[] Enc) {
        this.Encabezados = Enc;
        this.num_column = this.Encabezados.length;
    }

    public int getRowCount() {
        return Fila.size();
    }

    public int getColumnCount() {
        return this.num_column;
    }

    public Object[] getRowAt(int i) {
        return (Object[]) Fila.get(i);
    }

    public Object getValueAt(int row, int column) {
        Object[] datos;
        datos = (Object[]) Fila.get(row);
        return datos[column];
    }

    public String getColumnName(int column) {
        return Encabezados[column];
    }

    public Class getColumnClass(int column) {
        Object[] datos;
        datos = (Object[]) Fila.get(0);
        return datos[column].getClass();
    }

    public void delElemento(Object[] datos) {
        Fila.remove(datos);
        this.fireTableDataChanged();
    }

    public void delElemento(int indice) {
        Fila.remove(indice);
        this.fireTableDataChanged();
    }

    public void addElemento(Object[] datos) {
        this.fireTableDataChanged();
        Fila.addElement(datos);
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex > 0) {
            return false;
        } else {
            return true;
        }
    }

    public void setValueAt(Object value, int row, int col) {
        Object[] var = (Object[]) Fila.elementAt(row);
        var[col] = value;
        Fila.setElementAt(var, row);
        fireTableCellUpdated(row, col);
    }

    /**
     * Getter for property Fila.
     * @return Value of property Fila.
     */
    public java.util.Vector getFila() {
        return Fila;
    }

    /**
     * Setter for property Fila.
     * @param Fila New value of property Fila.
     */
    public void setFila(java.util.Vector Fila) {
        this.Fila = Fila;
    }

    public boolean contieneElemento(Object[] datos, int clave) {
        Object[] tmp = null;
        for (int x = 0; x < Fila.size(); x++) {
            tmp = (Object[]) Fila.elementAt(x);
            if (((String) tmp[clave]).compareTo((String) datos[clave]) == 0) {
                return true;
            }
        }
        return false;
    }
}
