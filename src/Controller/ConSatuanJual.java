/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Helper.MyHelper;
import Implement.ImplSatuanJual;
import Entity.SatuanJual;
import Table.TableSatuanJual;
import View.FormSatuanJual;
import java.util.List;
import Interface.IntSatuanJual;

/**
 *
 * @author mediatama
 */
public class ConSatuanJual {
    FormSatuanJual form;
    List<SatuanJual> mlist;
    IntSatuanJual dAO;
    int index = -1;

    public ConSatuanJual(FormSatuanJual form) {
        this.form = form;
        dAO = new ImplSatuanJual();
        refresh();
    }
    
    public void dataTable() {
        TableSatuanJual table = new TableSatuanJual(mlist);
        form.getTable().setModel(table);
    }
    
    public void btnTambah() {
        String input = MyHelper.pesanInput(form, "Nama satuan", "Input Nama Satuan", -1);
        if (input == null || input.isEmpty()){}
        else {
            SatuanJual obj = new SatuanJual();
            obj.setNama_satuan_jual(input);
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
            int key = mlist.get(index).getKode_satuan_jual();
            String input = MyHelper.pesanInput(form, "Nama satuan lama "+mlist.get(index).getNama_satuan_jual(), "Update Nama Satuan", -1);
            SatuanJual obj = new SatuanJual();
            obj.setNama_satuan_jual(input);
            obj.setKode_satuan_jual(key);
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
        dAO.delete(mlist.get(index).getKode_satuan_jual());
        refresh();
    }

    private void refresh() {
        mlist = dAO.get_all();
        dataTable();
    }
    
    
}
