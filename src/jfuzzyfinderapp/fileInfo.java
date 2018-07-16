/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jfuzzyfinderapp;

import java.io.File;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author Olanrewaju-PC
 */
public class fileInfo {
    public void getfileInfo(String filePath, JTable table1, JLabel label1, JLabel label2, JLabel label3)
    {       
        File archiveFile = new File(filePath);
        Long size = archiveFile.length();
        Long lastModified = archiveFile.lastModified();
        int noFiles = table1.getRowCount();
     
        label1.setText("Total Number of Files = " + noFiles);
        label2.setText("Archive Size = " + size.toString() + " KB");
        label3.setText("Last Modified = " + lastModified.toString());
    }
}
