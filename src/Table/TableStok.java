/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import Entity.Stok;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mediatama
 */
public class TableStok extends AbstractTableModel{
    
    List<Stok> mlist;

    public TableStok(List<Stok> mlist) {
        this.mlist = mlist;
    }
    
    @Override
    public int getRowCount() {
        return mlist.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No";
            case 1:
                return "Kode Barang";
            case 2:
                return "Stok";
            case 3:
                return "Tanggal Update";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return (rowIndex++ +1);
            case 1:
                return mlist.get(rowIndex).getKode_barang();
            case 2:
                return mlist.get(rowIndex).getStok();
            case 3:
                return mlist.get(rowIndex).getTgl_update();
            default:
                return null;
        }
    }
    
}
