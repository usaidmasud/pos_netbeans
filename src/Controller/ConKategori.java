/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Helper.MyHelper;
import Implement.ImplKategori;
import Entity.Kategori;
import Table.TableKategori;
import View.FormKategori;
import java.util.List;
import Interface.IntKategori;

/**
 *
 * @author mediatama
 */
public class ConKategori {
    FormKategori form;
    List<Kategori> mlist;
    IntKategori dAO;
    int index = -1;

    public ConKategori(FormKategori form) {
        this.form = form;
        dAO = new ImplKategori();
        refresh();
    }
    
    public void dataTable() {
        TableKategori table = new TableKategori(mlist);
        form.getTable().setModel(table);
        MyHelper.autoResize(form.getTable());
    }
    
    public void btnTambah() {
        String input = MyHelper.pesanInput(form, "Nama kategori", "Input Nama Kategori", -1);
        if (input == null || input.isEmpty()){}
        else {
            Kategori obj = new Kategori();
            obj.setNama_kategori(input);
            boolean cek = dAO.cek_nama_kategori(input);
            if (!cek && !input.equalsIgnoreCase("")){
                dAO.insert(obj);
                refresh();
            } else {
                MyHelper.pesan(form, "Nama kategori sudah ada", 2);
            }
        }
    }
    
    public void btnUpdate() {
        index = form.getTable().getSelectedRow();
        if (index < 0){
//            form.getTextCari().requestFocus();
        } else {
            int key = mlist.get(index).getKode_kategori();
            String input = MyHelper.pesanInput(form, "Nama kategori lama "+mlist.get(index).getNama_kategori(), "Update nama kategori", -1);
            Kategori obj = new Kategori();
            obj.setNama_kategori(input);
            obj.setKode_kategori(key);
            boolean cek = dAO.cek_nama_kategori(input);
            if (input == null || input.isEmpty())
            {} else
            {
                if (cek)
                {
                    MyHelper.pesan(form, "Nama kategori sama", 2);
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
        dAO.delete(mlist.get(index).getKode_kategori());
        refresh();
    }

    private void refresh() {
        mlist = dAO.get_all();
        dataTable();
    }
    
    
}
