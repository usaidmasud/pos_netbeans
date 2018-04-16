/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Implement.ImplSatuan;
import Interface.IntSatuan;
import Model.Satuan;
import Table.TableSatuan;
import View.FormSatuan;
import java.util.List;

/**
 *
 * @author mediatama
 */
public class ConSatuan {
    FormSatuan form;
    List<Satuan> mlist;
    IntSatuan dAO;

    public ConSatuan(FormSatuan form) {
        this.form = form;
        dAO = new ImplSatuan();
        mlist = dAO.get_all();
        dataTable();
    }
    
    public void dataTable() {
        TableSatuan table = new TableSatuan(mlist);
        form.getTable().setModel(table);
    }
    
    public void kosong() {
        form.getTextSatuan().setText("");
    }
    
    public void isi_field(int row) {
        form.getTextSatuan().setText(mlist.get(row).getNama_satuan());
    }
    
    private boolean cekField() {
        boolean hasil = false;
        if (form.getTextSatuan().getText() == null || form.getTextSatuan().getText() == "") {
            hasil = false;
        } else hasil = true;
        return hasil;
    }
    
    public void insert() {
        if (cekField()) {
            Satuan s = new Satuan();
            s.setNama_satuan(form.getTextSatuan().getText());
            dAO.insert(s);
        }
    }
    
    public void update() {
        if (cekField()) {
            Satuan s = new Satuan();
            s.setNama_satuan(form.getTextSatuan().getText());
            dAO.update(s);
        }
    }
    
    public void delete() {
        int row = form.getTable().getSelectedRow();
        dAO.delete(row);
    }
    
    
}
