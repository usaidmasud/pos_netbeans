/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import Entity.Group;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mediatama
 */
public class TableGroup extends AbstractTableModel{
    
    List<Group> mlist;

    public TableGroup(List<Group> mlist) {
        this.mlist = mlist;
    }
    
    @Override
    public int getRowCount() {
        return mlist.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No";
            case 1:
                return "Nama Group";
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
                return mlist.get(rowIndex).getNama_group();
            default:
                return null;
        }
    }
    
}
