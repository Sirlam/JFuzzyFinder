/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jfuzzyfinderapp;

import java.io.File;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Olanrewaju-PC
 */
public class ListFilesUtil {
     /**
     * List all the files and folders from a directory
     * @param directoryName to be listed
     */
    public void listFilesAndFolders(String directoryName, JTable table1){
 
        File directory = new File(directoryName);
 
        //get all the files from a directory
        File[] fList = directory.listFiles();
        int counter = -1;
        String filename = null;
        
        for (File file : fList){
            counter++;
            //System.out.println(file.getName());
            if (file.isDirectory()){
               listFilesAndFilesSubDirectories(file.getAbsolutePath(), table1);
               filename = "(Folder) " + file.getAbsolutePath();
            }
            else if(file.isFile()){
                filename = "(File) " + file.getName();
            }
            table1.removeAll();
            table1.repaint();
            DefaultTableModel dtm = (DefaultTableModel)table1.getModel();
            dtm.setNumRows(fList.length);
            dtm.fireTableDataChanged();
            table1.setValueAt(filename, counter, 0);
            
        }
    }
 
    /**
     * List all the files under a directory
     * @param directoryName to be listed
     */
    public void listFiles(String directoryName, JTable table1){
 
        File directory = new File(directoryName);
 
        //get all the files from a directory
        File[] fList = directory.listFiles();
 
        for (File file : fList){
            if (file.isFile()){
                System.out.println(file.getName());
            }
        }
    }
 
    /**
     * List all the folder under a directory
     * @param directoryName to be listed
     */
    public void listFolders(String directoryName, JTable table1){
 
        File directory = new File(directoryName);
 
        //get all the files from a directory
        File[] fList = directory.listFiles();
 
        for (File file : fList){
            if (file.isDirectory()){
                System.out.println(file.getName());
            }
        }
    }
 
    /**
     * List all files from a directory and its subdirectories
     * @param directoryName to be listed
     */
    public void listFilesAndFilesSubDirectories(String directoryName, JTable table1){
 
        File directory = new File(directoryName);
 
        //get all the files from a directory
        File[] fList = directory.listFiles();
 
        for (File file : fList){
            if (file.isFile()){
                System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()){
                listFilesAndFilesSubDirectories(file.getAbsolutePath(), table1);
            }
        }
    }
}
