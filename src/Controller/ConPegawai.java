/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Implement.ImplPegawai;
import Entity.Pegawai;
import Helper.MyHelper;
import Table.TablePegawai;
import View.FormPegawai;
import java.util.List;
import Interface.IntPegawai;
import View.FormPegawaiInput;

/**
 *
 * @author mediatama
 */
public class ConPegawai {
    FormPegawai form;
    FormPegawaiInput formInput;
    List<Pegawai> mlist;
    IntPegawai dAO;
    int index = -1;

    public ConPegawai(FormPegawai form) {
        this.form = form;
        dAO = new ImplPegawai();
        refresh();
    }
    
    public void dataTable() {
        TablePegawai table = new TablePegawai(mlist);
        form.getTable().setModel(table);
        MyHelper.autoResize(form.getTable());
    }
    
    public void add() {
        formInput = new FormPegawaiInput();
        formInput.show(true);
    }
    
    public void update() {
        index = form.getTable().getSelectedRow();
        if (index < 0){
//            form.getTextCari().requestFocus();
        } else {
//            int key = mlist.get(index).getKode_satuan_jual();
//            String input = MyHelper.pesanInput(form, "Nama satuan lama "+mlist.get(index).getNama_satuan_jual(), "Update Nama Satuan", -1);
//            Pegawai obj = new Pegawai();
//            obj.setNama_satuan_jual(input);
//            obj.setKode_satuan_jual(key);
//            boolean cek = dAO.cek_nama_satuan(input);
//            if (input == null || input.isEmpty())
//            {} else
//            {
//                if (cek)
//                {
//                    MyHelper.pesan(form, "Nama satuan sama", 2);
//                } else 
//                {
//                    dAO.update(obj);
//                    refresh();
//                }
//            }
        }
    }
    
    public void delete() {
        index = form.getTable().getSelectedRow();
        dAO.delete(mlist.get(index).getKode_pegawai());
        refresh();
    }

    private void refresh() {
        form.getTextSearch().setText("");
        mlist = dAO.get_all();
        dataTable();
    }
    
    
}
