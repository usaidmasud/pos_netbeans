/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Implement.ImplSatuan;
import Interface.IntSatuan;
import Model.Satuan;
import Table.TableSatuan;
import View.FormSatuan;
import java.util.List;

/**
 *
 * @author mediatama
 */
public class ConSatuan {
    FormSatuan form;
    List<Satuan> mlist;
    IntSatuan DAO;

    public ConSatuan(FormSatuan form) {
        this.form = form;
        DAO = new ImplSatuan();
        mlist = DAO.get_all();
        dataTable();
    }
    
    public void dataTable() {
        TableSatuan table = new TableSatuan(mlist);
        form.getTable().setModel(table);
    }
    
    
}
