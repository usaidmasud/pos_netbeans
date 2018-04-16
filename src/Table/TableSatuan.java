/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import Entity.Satuan;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mediatama
 */
public class TableSatuan extends AbstractTableModel{
    
    List<Satuan> mlist;

    public TableSatuan(List<Satuan> mlist) {
        this.mlist = mlist;
    }
    
    @Override
    public int getRowCount() {
        return mlist.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Satuan Barang";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return mlist.get(rowIndex).getNama_satuan();
            default:
                return null;
        }
    }
    
}
