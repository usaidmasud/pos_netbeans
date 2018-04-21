/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import Entity.Customer;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mediatama
 */
public class TableCustomer extends AbstractTableModel{
    
    List<Customer> mlist;

    public TableCustomer(List<Customer> mlist) {
        this.mlist = mlist;
    }
    
    @Override
    public int getRowCount() {
        return mlist.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No";
            case 1:
                return "Nama Customer";
            case 2:
                return "No ID";
            case 3:
                return "No Telpon";
            case 4:
                return "Alamat";
            case 5:
                return "Tgl Post";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowIndex++;
            case 1:
                return mlist.get(rowIndex).getNama_customer();
            case 2:
                return mlist.get(rowIndex).getNo_id();
            case 3:
                return mlist.get(rowIndex).getNo_telpon();
            case 4:
                return mlist.get(rowIndex).getAlamat();
            case 5:
                return mlist.get(rowIndex).getTgl_create();
            default:
                return null;
        }
    }
    
}
