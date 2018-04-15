/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Satuan;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author usaid
 */
public class Tabel extends AbstractTableModel{
    
    List<Satuan> mlist;

    public Tabel(List<Satuan> mlist) {
        this.mlist = mlist;
    }
    
    @Override
    public int getRowCount() {
        return mlist.size();
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nama Satuan";
            default:
                return null;
        }
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return mlist.get(rowIndex).getNama_satuan();
            case 1:
            default:
                return null;
        }
    }
    
}
