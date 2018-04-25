/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.BarangDetail_multi;
import java.util.List;

/**
 *
 * @author usaid
 */
public interface IntBarangDetail_multi {
    public void insert(BarangDetail_multi obj);
    public void update(BarangDetail_multi obj);
    public void delete(int keyWord);
    public List<BarangDetail_multi> get_all();
    public List<BarangDetail_multi> get_by_keyword(String keyWord);
}
