/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Stok;
import java.util.List;

/**
 *
 * @author usaid
 */
public interface IntStok {
    public void insert(Stok obj);
    public void update(Stok obj);
    public void delete(int keyWord);
    public List<Stok> get_all();
    public List<Stok> get_by_keyword(String keyWord);
}
