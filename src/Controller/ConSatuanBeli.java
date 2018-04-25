/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Helper.MyHelper;
import Implement.ImplSatuanBeli;
import Entity.SatuanBeli;
import Table.TableSatuanBeli;
import View.FormSatuanBeli;
import java.util.List;
import Interface.IntSatuanBeli;

/**
 *
 * @author mediatama
 */
public class ConSatuanBeli {
    FormSatuanBeli form;
    List<SatuanBeli> mlist;
    IntSatuanBeli dAO;
    int index = -1;

    public ConSatuanBeli(FormSatuanBeli form) {
        this.form = form;
        dAO = new ImplSatuanBeli();
        refresh();
    }
    
    public void dataTable() {
        TableSatuanBeli table = new TableSatuanBeli(mlist);
        form.getTable().setModel(table);
        MyHelper.autoResize(form.getTable());
    }
    
    public void btnTambah() {
        String input = MyHelper.pesanInput(form, "Nama satuan", "Input Nama Satuan", -1);
        if (input == null || input.isEmpty()){}
        else {
            SatuanBeli obj = new SatuanBeli();
            obj.setNama_satuan_beli(input);
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
            int key = mlist.get(index).getKode_satuan_beli();
            String input = MyHelper.pesanInput(form, "Nama satuan lama "+mlist.get(index).getNama_satuan_beli(), "Update Nama Satuan", -1);
            SatuanBeli obj = new SatuanBeli();
            obj.setNama_satuan_beli(input);
            obj.setKode_satuan_beli(key);
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
        dAO.delete(mlist.get(index).getKode_satuan_beli());
        refresh();
    }

    private void refresh() {
        mlist = dAO.get_all();
        dataTable();
    }
    
    
}
