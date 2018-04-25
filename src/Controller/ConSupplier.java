/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Implement.ImplSupplier;
import Entity.Supplier;
import Helper.MyHelper;
import Table.TableSupplier;
import View.FormSupplier;
import java.util.List;
import Interface.IntSupplier;
import View.FormCustomerInput;

/**
 *
 * @author mediatama
 */
public class ConSupplier {
    FormSupplier form;
    FormCustomerInput formInput;
    List<Supplier> mlist;
    IntSupplier dAO;
    int index = -1;

    public ConSupplier(FormSupplier form) {
        this.form = form;
        dAO = new ImplSupplier();
        refresh();
    }
    
    public void dataTable() {
        TableSupplier table = new TableSupplier(mlist);
        form.getTable().setModel(table);
        MyHelper.autoResize(form.getTable());
    }
    
    public void add() {
        formInput = new FormCustomerInput();
        formInput.show(true);
    }
    
    public void update() {
        index = form.getTable().getSelectedRow();
        if (index < 0){
//            form.getTextCari().requestFocus();
        } else {
//            int key = mlist.get(index).getKode_satuan_jual();
//            String input = MyHelper.pesanInput(form, "Nama satuan lama "+mlist.get(index).getNama_satuan_jual(), "Update Nama Satuan", -1);
//            Supplier obj = new Supplier();
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
        dAO.delete(mlist.get(index).getKode_supplier());
        refresh();
    }

    private void refresh() {
        form.getTextSearch().setText("");
        mlist = dAO.get_all();
        dataTable();
    }
    
    
}
