/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Barang;
import java.util.List;

/**
 *
 * @author usaid
 */
public interface IntBarang_multi {
    public void insert(Barang obj);
    public void update(Barang obj);
    public void delete(int keyWord);
    public List<Barang> get_all();
    public List<Barang> get_by_keyword(String keyWord);
}
