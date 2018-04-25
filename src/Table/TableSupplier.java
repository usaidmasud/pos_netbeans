/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import Entity.Supplier;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mediatama
 */
public class TableSupplier extends AbstractTableModel{
    
    List<Supplier> mlist;

    public TableSupplier(List<Supplier> mlist) {
        this.mlist = mlist;
    }
    
    @Override
    public int getRowCount() {
        return mlist.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No";
            case 1:
                return "Nama Supplier";
            case 2:
                return "No Telpon";
            case 3:
                return "Alamat";
            case 4:
                return "Tgl Post";
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
                return mlist.get(rowIndex).getNama_supplier();
            case 2:
                return mlist.get(rowIndex).getNo_telpon();
            case 3:
                return mlist.get(rowIndex).getAlamat();
            case 4:
                return mlist.get(rowIndex).getTgl_create();
            default:
                return null;
        }
    }
    
}
