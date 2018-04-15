/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Satuan;

import java.util.List;

/**
 *
 * @author usaid
 */
public class ControllerSatuan {
    FormSatuan form;
    List<Satuan> mlist;
    IntSatuan dao;

    public ControllerSatuan(FormSatuan form) {
        this.form = form;
        dao = new ImplSatuan();
        mlist = dao.get_all();
        
        dataTable();
    }
    
    public void dataTable() {
        Tabel tabel = new Tabel(mlist);
        form.getTable().setModel(tabel);
    }
    
    
}
