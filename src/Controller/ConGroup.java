/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Helper.MyHelper;
import Implement.ImplGroup;
import Entity.Group;
import Table.TableGroup;
import View.FormGroup;
import java.util.List;
import Interface.IntGroup;

/**
 *
 * @author mediatama
 */
public class ConGroup {
    FormGroup form;
    List<Group> mlist;
    IntGroup dAO;
    int index = -1;

    public ConGroup(FormGroup form) {
        this.form = form;
        dAO = new ImplGroup();
        refresh();
    }
    
    public void dataTable() {
        TableGroup table = new TableGroup(mlist);
        form.getTable().setModel(table);
        MyHelper.autoResize(form.getTable());
    }
    
    public void btnTambah() {
        String input = MyHelper.pesanInput(form, "Nama group", "Input Nama Group", -1);
        if (input == null || input.isEmpty()){}
        else {
            Group obj = new Group();
            obj.setNama_group(input);
            boolean cek = dAO.cek_nama_group(input);
            if (!cek && !input.equalsIgnoreCase("")){
                dAO.insert(obj);
                refresh();
            } else {
                MyHelper.pesan(form, "Nama group sudah ada", 2);
            }
        }
    }
    
    public void btnUpdate() {
        index = form.getTable().getSelectedRow();
        if (index < 0){
//            form.getTextCari().requestFocus();
        } else {
            int key = mlist.get(index).getKode_group();
            String input = MyHelper.pesanInput(form, "Nama group lama "+mlist.get(index).getNama_group(), "Update nama group", -1);
            Group obj = new Group();
            obj.setNama_group(input);
            obj.setKode_group(key);
            boolean cek = dAO.cek_nama_group(input);
            if (input == null || input.isEmpty())
            {} else
            {
                if (cek)
                {
                    MyHelper.pesan(form, "Nama group sama", 2);
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
        dAO.delete(mlist.get(index).getKode_group());
        refresh();
    }

    private void refresh() {
        mlist = dAO.get_all();
        dataTable();
    }
    
    
}
