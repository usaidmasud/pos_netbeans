/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Helper.MyHelper;
import Implement.ImplSatuan;
import Interface.IntSatuan;
import Entity.Satuan;
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
    int index = -1;

    public ConSatuan(FormSatuan form) {
        this.form = form;
        dAO = new ImplSatuan();
        refresh();
    }
    
    public void dataTable() {
        TableSatuan table = new TableSatuan(mlist);
        form.getTable().setModel(table);
    }
    
    public void btnTambah() {
        String input = MyHelper.pesanInput(form, "Nama satuan", "Input Nama Satuan", -1);
        if (input == null || input.isEmpty()){}
        else {
            Satuan obj = new Satuan();
            obj.setNama_satuan(input);
            boolean cek = dAO.cek_nama_satuan(input);
            if (!cek && !input.equalsIgnoreCase("")){
                dAO.insert(obj);
                refresh();
            } else {
                MyHelper.pesan(form, "Nama satuan sudah ada", 2);
            }
        }
    }
    
    public void btnUpdate() {
        index = form.getTable().getSelectedRow();
        if (index < 0){
//            form.getTextCari().requestFocus();
        } else {
            int key = mlist.get(index).getKode_satuan();
            String input = MyHelper.pesanInput(form, "Nama satuan lama "+mlist.get(index).getNama_satuan(), "Update Nama Satuan", -1);
            Satuan obj = new Satuan();
            obj.setNama_satuan(input);
            obj.setKode_satuan(key);
            boolean cek = dAO.cek_nama_satuan(input);
            if (input == null || input.isEmpty())
            {} else
            {
                if (cek)
                {
                    MyHelper.pesan(form, "Nama satuan sama", 2);
                } else 
                {
                    dAO.update(obj);
                    refresh();
                }
            }
        }
    }
    
    public void btnDelete() {
        index = form.getTable().getSelectedRow();
        dAO.delete(mlist.get(index).getKode_satuan());
        refresh();
    }

    private void refresh() {
        mlist = dAO.get_all();
        dataTable();
    }
    
    
}
