/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import Entity.Barang;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mediatama
 */
public class TableBarang extends AbstractTableModel{
    
    List<Barang> mlist;

    public TableBarang(List<Barang> mlist) {
        this.mlist = mlist;
    }
    
    @Override
    public int getRowCount() {
        return mlist.size();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No";
            case 1:
                return "Barangname";
            case 2:
                return "Kodekategori";
            case 3:
                return "Kodesatuan";
            case 4:
                return "Hargabeli";
            case 5:
                return "Hargasatuan";
            case 6:
                return "Stokminimal";
            case 7:
                return "Tglbeli";
            case 8:
                return "Tglcreate";
            case 9:
                return "Hpp";
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
                return mlist.get(rowIndex).getNama_barang();
            case 3:
                return mlist.get(rowIndex).getKode_kategori();
            case 4:
                return mlist.get(rowIndex).getKode_satuan();
            case 5:
                return mlist.get(rowIndex).getNama_group();
            case 6:
                return mlist.get(rowIndex).getTgl_create();
            case 7:
                return mlist.get(rowIndex).getNama_group();
            case 8:
                return mlist.get(rowIndex).getTgl_create();
            case 9:
                return mlist.get(rowIndex).getNama_group();
            case 10:
                return mlist.get(rowIndex).getTgl_create();
            default:
                return null;
        }
    }
    
}
