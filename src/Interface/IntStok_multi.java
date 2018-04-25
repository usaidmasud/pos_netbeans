/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Stok_multi;
import java.util.List;

/**
 *
 * @author usaid
 */
public interface IntStok_multi {
    public void insert(Stok_multi obj);
    public void update(Stok_multi obj);
    public void delete(int keyWord);
    public List<Stok_multi> get_all();
    public List<Stok_multi> get_by_keyword(String keyWord);
}
