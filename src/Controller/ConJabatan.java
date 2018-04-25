/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Helper.MyHelper;
import Implement.ImplJabatan;
import Entity.Jabatan;
import Table.TableJabatan;
import View.FormJabatan;
import java.util.List;
import Interface.IntJabatan;

/**
 *
 * @author mediatama
 */
public class ConJabatan {
    FormJabatan form;
    List<Jabatan> mlist;
    IntJabatan dAO;
    int index = -1;

    public ConJabatan(FormJabatan form) {
        this.form = form;
        dAO = new ImplJabatan();
        refresh();
    }
    
    public void dataTable() {
        TableJabatan table = new TableJabatan(mlist);
        form.getTable().setModel(table);
        MyHelper.autoResize(form.getTable());
    }
    
    public void btnTambah() {
        String input = MyHelper.pesanInput(form, "Nama jabatan", "Input Nama Jabatan", -1);
        if (input == null || input.isEmpty()){}
        else {
            Jabatan obj = new Jabatan();
            obj.setNama_jabatan(input);
            boolean cek = dAO.cek_nama_jabatan(input);
            if (!cek && !input.equalsIgnoreCase("")){
                dAO.insert(obj);
                refresh();
            } else {
                MyHelper.pesan(form, "Nama jabatan sudah ada", 2);
            }
        }
    }
    
    public void btnUpdate() {
        index = form.getTable().getSelectedRow();
        if (index < 0){
//            form.getTextCari().requestFocus();
        } else {
            int key = mlist.get(index).getKode_jabatan();
            String input = MyHelper.pesanInput(form, "Nama jabatan lama "+mlist.get(index).getNama_jabatan(), "Update nama jabatan", -1);
            Jabatan obj = new Jabatan();
            obj.setNama_jabatan(input);
            obj.setKode_jabatan(key);
            boolean cek = dAO.cek_nama_jabatan(input);
            if (input == null || input.isEmpty())
            {} else
            {
                if (cek)
                {
                    MyHelper.pesan(form, "Nama jabatan sama", 2);
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
        dAO.delete(mlist.get(index).getKode_jabatan());
        refresh();
    }

    private void refresh() {
        mlist = dAO.get_all();
        dataTable();
    }
    
    
}
