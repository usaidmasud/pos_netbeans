/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Supplier;
import java.util.List;

/**
 *
 * @author usaid
 */
public interface IntSupplier {
    public void insert(Supplier sup);
    public void update(Supplier sup);
    public void delete(String keyWord);
    public List<Supplier> get_all();
    public List<Supplier> get_by_keyword(String keyWord);
}
