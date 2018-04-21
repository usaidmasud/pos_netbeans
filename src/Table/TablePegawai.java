/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import Entity.Pegawai;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mediatama
 */
public class TablePegawai extends AbstractTableModel{
    
    List<Pegawai> mlist;

    public TablePegawai(List<Pegawai> mlist) {
        this.mlist = mlist;
    }
    
    @Override
    public int getRowCount() {
        return mlist.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No";
            case 1:
                return "Nama Pegawai";
            case 2:
                return "Gender";
            case 3:
                return "No Telpon";
            case 4:
                return "Email";
            case 5:
                return "Jabatan";
            case 6:
                return "Alamat";
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
                return mlist.get(rowIndex).getNama_pegawai();
            case 2:
                return mlist.get(rowIndex).getGender();
            case 3:
                return mlist.get(rowIndex).getNo_telpon();
            case 4:
                return mlist.get(rowIndex).getEmail();
            case 5:
                return mlist.get(rowIndex).getKode_jabatan();
            case 6:
                return mlist.get(rowIndex).getAlamat();
            default:
                return null;
        }
    }
    
}
