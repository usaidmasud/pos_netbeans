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
public interface IntSatuan {
    public void Insert(Satuan satuan);
    public void Update(Satuan satuan);
    public void Delete(int keyWord);
    public List<Satuan> get_all();
    public List<Satuan> get_by_id(String keyWord);
}
