/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Implement.ImplUser;
import Entity.User;
import Helper.MyHelper;
import Table.TableBarang;
import View.FormUser;
import java.util.List;
import View.FormUserInput;

/**
 *
 * @author mediatama
 */
public class ConUser {
    FormUser form;
    FormUserInput formInput;
    List<User> mlist;
    Interface.IntUser dAO;
    Interface.IntPegawai dAOPegawai;
    Interface.IntGroup dAOGroup;
    int index = -1;

    public ConUser(FormUser form) {
        this.form = form;
        dAO = new ImplUser();
        dAOGroup = new Implement.ImplGroup();
        dAOPegawai = new Implement.ImplPegawai();
        refresh();
    }
    
    public void dataTable() {
        TableBarang table = new TableBarang(mlist);
        form.getTable().setModel(table);
        MyHelper.autoResize(form.getTable());
    }
    
    public void add() {
        formInput = new FormUserInput();
        formInput.cs = this;
        formInput.setTitle("Input Data User");
        formInput.getBtnSimpan().setText("Simpan");
        
        kosongInputan();
        formInput.show(true);
    }
    
    public void add_action() {
        //validasi inputan
        //simpan
        User obj = new User();
        obj.setKode_user(dAO.get_kode_user());
        obj.setUsername(formInput.getTextUsername().getText());
        obj.setPassword(formInput.getTextPassword().getText());
        obj.setKode_pegawai(dAOPegawai.get_kode(formInput.getComboPegawai().getSelectedItem().toString()));
        obj.setKode_group(dAOGroup.get_kode(formInput.getComboGroup().getSelectedItem().toString()));
        dAO.insert(obj);
        kosongInputan();
        refresh();
    }
    
    public void update() {
        index = form.getTable().getSelectedRow();
        if (index < 0){
            MyHelper.pesan(form, "Pilih data dulu", 0);
        } else {
            formInput = new FormUserInput();
            formInput.setTitle("Update Data User");
            formInput.getBtnSimpan().setText("Update");
            isiInputan(index);
            formInput.show(true);
            
        }
    }
    
    public void delete() {
        index = form.getTable().getSelectedRow();
        dAO.delete(mlist.get(index).getKode_user());
        refresh();
    }

    private void refresh() {
        form.getTextSearch().setText("");
        mlist = dAO.get_all();
        dataTable();
    }

    private void kosongInputan() {
        formInput.getTextUsername().setText("");
        formInput.getTextPassword().setText("");
        isiCombobox();
    }
    
    boolean rules() {
        boolean cek = false;
        if (formInput.getTextUsername().getText() == null) {
            cek = false;
            formInput.getTextUsername().requestFocus();
        } else if (formInput.getTextPassword().getText() == null) {
            cek = false;
            formInput.getTextPassword().requestFocus();
        } else if (formInput.getComboPegawai().getSelectedIndex() < 0) {
            cek = false;
            formInput.getComboPegawai().requestFocus();
        } else if (formInput.getComboGroup().getSelectedIndex() < 0) {
            cek = false;
            formInput.getComboGroup().requestFocus();
        } else cek = true;
        return cek;
    }

    private void isiInputan(int index) {
        isiCombobox();
        formInput.getTextUsername().setText(mlist.get(index).getUsername());
        formInput.getTextPassword().setText("");
        formInput.getTextPassword().setEnabled(false);
        formInput.getComboPegawai().setSelectedItem(dAOPegawai.get_nama(mlist.get(index).getKode_pegawai()));
        formInput.getComboGroup().setSelectedItem(dAOGroup.get_nama(mlist.get(index).getKode_group()));
    }

    private void isiCombobox() {
        formInput.getComboPegawai().removeAllItems();
        formInput.getComboGroup().removeAllItems();
        List<Entity.Pegawai> list_pegawai = dAOPegawai.get_all();
        List<Entity.Group> list_group = dAOGroup.get_all();
        for (int i = 0; i < list_pegawai.size(); i++) {
            formInput.getComboPegawai().addItem(list_pegawai.get(i).getNama_pegawai());
        }
        for (int i = 0; i < list_group.size(); i++) {
            formInput.getComboGroup().addItem(list_group.get(i).getNama_group());
        }
    }
}
