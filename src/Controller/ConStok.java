/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Helper.MyHelper;
import Implement.ImplStok;
import Entity.Stok;
import Table.TableStok;
import View.FormStok;
import java.util.List;
import Interface.IntStok;

/**
 *
 * @author mediatama
 */
public class ConStok {
    FormStok form;
    List<Stok> mlist;
    IntStok dAO;
    int index = -1;

    public ConStok(FormStok form) {
        this.form = form;
        dAO = new ImplStok();
        refresh();
    }
    
    public void dataTable() {
        TableStok table = new TableStok(mlist);
        form.getTable().setModel(table);
        MyHelper.autoResize(form.getTable());
    }
    
    private void refresh() {
        mlist = dAO.get_all();
        dataTable();
    }
    
    
}
