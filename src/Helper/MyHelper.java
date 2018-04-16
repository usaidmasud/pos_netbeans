/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Database.ConnectDB;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author SAYYID
 */
public class MyHelper {
    
    public static void autoResize(JTable table)
    {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            if(width > 300)
                width=300;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
    }
    
    public static String formatIDR(int uang)
    {
        DecimalFormat df = new DecimalFormat();
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setCurrencySymbol("$");
        dfs.setGroupingSeparator('.');
        dfs.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(dfs);
        return df.format(uang);
    }
    
    public static void pesan(Component parent, String message, int messageType)
    {
        JOptionPane.showMessageDialog(parent, message, "Point Of Sales", messageType);
    }
    
    public static String pesanInput(Component parent, String message, String title, int messageType)
    {
        return JOptionPane.showInputDialog(parent, 
        message, title, messageType);
    }
    
    public static int pesanKonfirmasi(Component parent,Object[] opt, String message, int messageType)
    {
        int n = JOptionPane.showOptionDialog(parent, message,"Point Of Sales",JOptionPane.YES_NO_OPTION,
        messageType,
        null,//do not use a custom Icon
        opt,//the titles of buttons
        opt[0]);//default button title
        return n;
    }
    
    public static int pesanCloseForm(Component parent)
    {
        Object[] opt = {"Ya, tutup", "Tidak"};
        int n = JOptionPane.showOptionDialog(parent, "Tutup form?","Point Of Sales",JOptionPane.YES_NO_OPTION,
        3,
        null,//do not use a custom Icon
        opt,//the titles of buttons
        opt[0]);//default button title
        return n;
    }
    
    public static void jeda(int jeda)
    {
        try {
            Thread.sleep(jeda);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void callReport(HashMap params, String file, String fileNameOutput, String target)
    {
        try {
            Connection connect = ConnectDB.connection();
            fileNameOutput += " "+tanggalIndonesiaFull(new Date());
            
            ReportControl rc = new ReportControl();
            String report =  AbsolutePath.getPathReport().concat(file+".jrxml");
            System.out.println(report);
            JasperReport jr = JasperCompileManager.compileReport(report);
            
            JasperPrint jp = JasperFillManager.fillReport(jr, params, connect);
            if (target.equals("pdf")) {
                rc.pdfExporter(jp, fileNameOutput);
            } else if (target.equals("xls")) {
                rc.xlsExporter(jp, fileNameOutput);
            } else if (target.equals("rtf")) {
                rc.rtfExporter(jp, fileNameOutput);
            } else if (target.equals("")) {
                rc.previewReport(jp, report);
            }
        } catch (JRException ex) {
            MyHelper.pesan(null, ex.getMessage(), 0);
        }
    }
    
    public static String tanggalKulon(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
    public static Date tanggalKulon(String date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date hasil = null;
        try {
            hasil = sdf.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(MyHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
    
    public static String tanggalIndonesia(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(date);
    }
    
    public static String tanggalKulonFull(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
    
    public static String tanggalIndonesiaFull(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH_mm_ss");
        return sdf.format(date);
    }
    
    public static String jam(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(date);
    }

    public static void setWaktuIndonesia() {
        Locale locale = new Locale ("id", "ID"); 
        Locale.setDefault(locale);
    }
    
    public static void callPdf(String fileName)
    {
        Process p = null;
        try {
            p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+AbsolutePath.getPathSaveReport()+fileName);
            p.waitFor();
        } catch (IOException ex) {
            Logger.getLogger(MyHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void copyImage(File fileInput, String copyTo)
    {
        BufferedImage image;
        try {
            image = ImageIO.read(fileInput);
            String cek = fileInput.getName().substring(fileInput.getName().length()-3, fileInput.getName().length());
            String to = "";
            if (cek.equals("png")) to = "png";
            else if (cek.equals("PNG")) to = "PNG";
            else if (cek.equals("jpg")) to = "jpg";
            else if (cek.equals("JPG")) to = "JPG";
            else if (cek.equals("jpg")) to = "gif";
            else if (cek.equals("jpg")) to = "GIF";
            ImageIO.write(image, to,new File(copyTo + fileInput.getName()));
        } catch (IOException ex) {
            MyHelper.pesan(null, ex.getMessage(), 0);
        } catch (Exception exx)
        {
            MyHelper.pesan(null, exx.getMessage(), 0);
        }
    }
    
    public static boolean isInteger(String str)  
    {  
        try {  
          Integer d = Integer.parseInt(str);  
        } catch(NumberFormatException nfe)  
        {  
          return false;  
        }  
        return true;  
    }
    
    public static int[] terbilangStok(int[] isi, String[] satuan, int jumlah) {
        int[] hasil = new int[isi.length];
        int stok = 0;
        int sisa = 0;
        for (int i = 0; i < hasil.length; i++) {
            if (i == 0)
            {
                stok = jumlah / isi[i];
                hasil[i] = stok;
            } else {
                sisa = jumlah % isi[i-1];
                stok = sisa / isi[i];
                hasil[i] = stok;
            }
        }
        return hasil;
    }
//    public static int[] terbilangStok(int[] isi, String[] satuan, int jumlah)
//    {
////        int[] isi = {1, 13};
////        String[] satuan = {"DUS","BUNGKUS"};
//        int[] hasil = new int[0];
//        if (isi.length == 1) {
//            hasil = new int[1];
//            hasil[0] = jumlah;
//        } else
//        {
//            int[] bagiSatuan = new int[isi.length-1];
//            for (int j = 0; j < bagiSatuan.length; j++)
//            {
//                int hitung = 1;
//                for (int i = j+1; i < isi.length; i++) {
//                    hitung *= isi[i];
//                }
//                bagiSatuan[j] = hitung;
//            }
//            int hitungA = 0;
//            int sisaA = 0;
//            hasil = new int[bagiSatuan.length+1];
//            for (int i = 0; i < isi.length; i++)
//            {
//                if (i == 0)
//                {
//                    hitungA = jumlah / bagiSatuan[i];
//                    hasil[i] = hitungA;
//                } else if (i > 0 && i < isi.length-1){
//                    sisaA = jumlah % bagiSatuan[i-1];
//                    hitungA = sisaA / bagiSatuan[i];
//                    hasil[i] = hitungA;
//                } else {
//                    sisaA = jumlah % bagiSatuan[i-1];
//                    hasil[i] = sisaA;
//                }
//            }
//        }
//        return hasil;
//    }
    
    public static String terbilangStokString(int[] isi, String[] satuan, int jumlah)
    {
        int[] hasil = new int[isi.length];
        int stok = 0;
        int sisa = 0;
        for (int i = 0; i < hasil.length; i++) {
            if (i == 0)
            {
                stok = jumlah / isi[i];
                hasil[i] = stok;
            } else {
                sisa = jumlah % isi[i-1];
                stok = sisa / isi[i];
                hasil[i] = stok;
            }
        }
        String terbilang = "";
        for (int i = 0; i < hasil.length; i++) {
             terbilang += hasil[i] + " " + satuan[i]+" ";
        }
        return terbilang.trim();
    }
    
//    public static void updateStokBarang2(String kodeBarang)
//    {
//        DAOBarang dAOBarang;
//        dAOBarang = new DAOBarangImpl();
//        List<DetailBarang> recordDetail;
//        List<Barang> record;
//        record = dAOBarang.getRecordBarang(kodeBarang);
//        int jumlah = record.get(0).getJumlahStok();
//        recordDetail = dAOBarang.getRecordBarangDetail(kodeBarang);
//        
//        String[] satuan = new String[recordDetail.size()];
//        int[] isi = new int[recordDetail.size()];
//        for (int i = 0; i < recordDetail.size(); i++) {
//            satuan[i] = recordDetail.get(i).getSatuanJual();
//            isi[i] = recordDetail.get(i).getIsi();
//        }
//        int[] hasil = new int[0];
//        if (isi.length == 1) {
//            hasil = new int[1];
//            hasil[0] = jumlah;
//        } else
//        {
//            int[] bagiSatuan = new int[isi.length-1];
//            for (int j = 0; j < bagiSatuan.length; j++)
//            {
//                int hitung = 1;
//                for (int i = j+1; i < isi.length; i++) {
//                    hitung *= isi[i];
//                }
//                bagiSatuan[j] = hitung;
//            }
//            int hitungA = 0;
//            int sisaA = 0;
//            hasil = new int[bagiSatuan.length+1];
//            for (int i = 0; i < isi.length; i++)
//            {
//                if (i == 0)
//                {
//                    hitungA = jumlah / bagiSatuan[i];
//                    hasil[i] = hitungA;
//                } else if (i > 0 && i < isi.length-1){
//                    sisaA = jumlah % bagiSatuan[i-1];
//                    hitungA = sisaA / bagiSatuan[i];
//                    hasil[i] = hitungA;
//                } else {
//                    sisaA = jumlah % bagiSatuan[i-1];
//                    hasil[i] = sisaA;
//                }
//            }
//        }
//        String ss = "";
//        for (int i = 0; i < hasil.length; i++) {
//            ss += hasil[i]+" "+satuan[i]+" ";
//        }
//        dAOBarang.updateStok2(kodeBarang, ss.trim());
//        
//    }
//    
//    public static void updateStokBarang2xx(String kodeBarang, String[] satuan, int[] isi, int jumlah, DAOBarang dAOBarang)
//    {
//        int[] hasil = new int[0];
//        if (isi.length == 1) {
//            hasil = new int[1];
//            hasil[0] = jumlah;
//        } else
//        {
//            int[] bagiSatuan = new int[isi.length-1];
//            for (int j = 0; j < bagiSatuan.length; j++)
//            {
//                int hitung = 1;
//                for (int i = j+1; i < isi.length; i++) {
//                    hitung *= isi[i];
//                }
//                bagiSatuan[j] = hitung;
//            }
//            int hitungA = 0;
//            int sisaA = 0;
//            hasil = new int[bagiSatuan.length+1];
//            for (int i = 0; i < isi.length; i++)
//            {
//                if (i == 0)
//                {
//                    hitungA = jumlah / bagiSatuan[i];
//                    hasil[i] = hitungA;
//                } else if (i > 0 && i < isi.length-1){
//                    sisaA = jumlah % bagiSatuan[i-1];
//                    hitungA = sisaA / bagiSatuan[i];
//                    hasil[i] = hitungA;
//                } else {
//                    sisaA = jumlah % bagiSatuan[i-1];
//                    hasil[i] = sisaA;
//                }
//            }
//        }
//        String ss = "";
//        for (int i = 0; i < hasil.length; i++) {
//            ss += hasil[i]+" "+satuan[i]+" ";
//        }
//        dAOBarang.updateStok2(kodeBarang, ss.trim());
//        
//    }
//    
    public static int getHasilBagi(String[] arrSatuan, int[] arrIsi, String inputSatuan, int inputValue)
    {
        int hasil = 1;
        for (int i = 0; i < arrSatuan.length; i++) {
            if (arrSatuan[i].equals(inputSatuan)) {
                hasil = arrIsi[i] * inputValue;
                break;
            }
        }
        return hasil;
    }
    
    public static void backupDB(Component parent, String user, String password, String lokasi, String dbName, String pathXampp)
    {
        try{
            lokasi += tanggalIndonesia(new Date())+".sql";
            if(lokasi.isEmpty()){
                System.out.println("Pilih lokasi backup terlebih dahulu");
            } else{
                Process process;
//                process = Runtime.getRuntime().exec("C:/xampp/mysql/bin/mysqldump.exe -hlocalhost -uroot -p --add-drop-database -B db_cs -r "+lokasi);

                if (password.equalsIgnoreCase("") || password == null)
                process = Runtime.getRuntime().exec(pathXampp+"\\mysql\\bin\\mysqldump -hlocalhost -u\""+user+"\" --add-drop-database -B \""+dbName+"\" -r "+"\""+lokasi+"\"");
                else
                process = Runtime.getRuntime().exec(pathXampp+"\\mysql\\bin\\mysqldump -hlocalhost -u\""+user+"\" -p\""+password+"\" --add-drop-database -B \""+dbName+"\" -r "+"\""+lokasi+"\"");
                int prosesSukses = process.waitFor();
                if(prosesSukses == 0){
                    System.out.println("Berhasil dibackup");
                } else {
                    System.err.println("Backup database gagal");
                }            
            }
        }catch(IOException | InterruptedException e){
//            pesan(parent, "Error : "+e.getMessage(), 0);
            System.err.println("Error : "+e.getMessage());
        }
    }
    
    public static void restoreDB (String path, String pathXampp, String user, String password)
    {
        try{
            if(path.isEmpty()){
                JOptionPane.showMessageDialog(null, "Pilih lokasi restore terlebih dahulu");
            } else{
//                String user="root";
//                String path = "D:/04-01-2018.sql/";
//                String password="";

                String[] restoreCMD = new String[]{pathXampp+"/mysql/bin/mysql.exe", "--user="+user, "--password="+password,"-e", "source "+path };
                //mysql -h localhost -u root -p db_cs <d:\04-01-2018.sql
                Process process;
                
                process = Runtime.getRuntime().exec(restoreCMD);
                int prosesSukses=process.waitFor();

                if (prosesSukses == 0){
                    pesan(null, "Restore database Sukses", 1);
                } else {
                    pesan(null, "Restore database gagal", 2);
                }
            }
        } catch (HeadlessException | IOException | InterruptedException e){
            pesan(null, "ERROR : "+e.getMessage(), 0);
        }
    }
    
    public static void startXampp(String pathXampp)
    {
        try {
            Process process;

            process = Runtime.getRuntime().exec(pathXampp+"/xampp_start.exe");
            int prosesSukses = process.waitFor();
            if (prosesSukses == 0){
                System.out.println("mysql is running");
            } else {
                System.err.println("mysql is stopped");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(MyHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MyHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void stopXampp(String pathXampp)
    {
        try {
            Process process;

            process = Runtime.getRuntime().exec(pathXampp+"/xampp_stop.exe");
            int prosesSukses = process.waitFor();
            if (prosesSukses == 0){
                System.out.println("mysql was stopped");
            } else {
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(MyHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MyHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
