/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.BarangDetail;
import java.util.List;

/**
 *
 * @author usaid
 */
public interface IntBarangDetail {
    public void insert(BarangDetail obj);
    public void update(BarangDetail obj);
    public void delete(int keyWord);
    public List<BarangDetail> get_all();
    public List<BarangDetail> get_by_keyword(String keyWord);
}
