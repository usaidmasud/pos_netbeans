/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Implement.ImplCustomer;
import Entity.Customer;
import Table.TableCustomer;
import View.FormCustomer;
import java.util.List;
import Interface.IntCustomer;
import View.FormCustomerInput;

/**
 *
 * @author mediatama
 */
public class ConCustomer {
    FormCustomer form;
    FormCustomerInput formInput;
    List<Customer> mlist;
    IntCustomer dAO;
    int index = -1;

    public ConCustomer(FormCustomer form) {
        this.form = form;
        dAO = new ImplCustomer();
        refresh();
    }
    
    public void dataTable() {
        TableCustomer table = new TableCustomer(mlist);
        form.getTable().setModel(table);
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
//            Customer obj = new Customer();
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
        dAO.delete(mlist.get(index).getKode_customer());
        refresh();
    }

    private void refresh() {
        form.getTextSearch().setText("");
        mlist = dAO.get_all();
        dataTable();
    }
    
    
}
