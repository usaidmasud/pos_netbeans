/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Model.Satuan;
import java.util.List;

/**
 *
 * @author mediatama
 */
public interface IntSatuan {
    public void insert(Satuan satuan);
    public void update(Satuan satuan);
    public void delete(int keyWord);
    public List<Satuan> get_all();
    public List<Satuan> get_by_keyword(String keyWord);
}
