/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Main.Main;
import java.io.File;
import java.net.URISyntaxException;
import java.security.CodeSource;

/**
 *
 * @author Bang Gosir
 */
public class AbsolutePath 
{
    
    public static String getPathReport() 
    {
//        return System.getProperty("user.dir") + "\\dist\\classes\\Laporan\\";
        CodeSource codeSource = Main.class.getProtectionDomain().getCodeSource();
        File rootPath = null;
        try {
            rootPath = new File(codeSource.getLocation().toURI().getPath());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }           
        return rootPath.getParentFile().getParent()+"\\dist\\classes\\Laporan\\".replace("\\", "/");
    }
    
    public static String getPathSaveReport() 
    {
        CodeSource codeSource = Main.class.getProtectionDomain().getCodeSource();
        File rootPath = null;
        try {
            rootPath = new File(codeSource.getLocation().toURI().getPath());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }           
        return rootPath.getParentFile().getParent()+"\\dist\\classes\\Output\\";
    }
    
    public static String getPathImage() 
    {
        CodeSource codeSource = Main.class.getProtectionDomain().getCodeSource();
        File rootPath = null;
        try {
            rootPath = new File(codeSource.getLocation().toURI().getPath());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }           
        return rootPath.getParentFile().getParent()+"\\dist\\classes\\Images\\";
    }
    public static String getPathImageBtn() 
    {
        CodeSource codeSource = Main.class.getProtectionDomain().getCodeSource();
        File rootPath = null;
        try {
            rootPath = new File(codeSource.getLocation().toURI().getPath());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }           
        return rootPath.getParentFile().getParent()+"\\dist\\classes\\Images\\button\\".replace("\\", "/");
    }
    
    public static String getPathBackupDatabase() 
    {
        CodeSource codeSource = Main.class.getProtectionDomain().getCodeSource();
        File rootPath = null;
        try {
            rootPath = new File(codeSource.getLocation().toURI().getPath());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }           
        return rootPath.getParentFile().getParent()+"\\dist\\classes\\BackupDB\\";
    }
    
}
