/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jfuzzyfinderapp;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Olanrewaju-PC
 */
public class selectArchive {
    public void chooseArchive(File archiveFile, JTextField field1, JLabel label1, JLabel label2)
    {
        try
        {
            JFileChooser jfc = new JFileChooser();
            jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = jfc.showDialog(jfc,null);
            if(result == JFileChooser.CANCEL_OPTION)
            {
                jfc.removeAll();
            }
            archiveFile = jfc.getSelectedFile();
            if(archiveFile.getName().endsWith(".zip") || archiveFile.getName().endsWith(".rar"))
            {
                field1.setText(archiveFile.getAbsolutePath());
                label1.setVisible(true);
                label2.setVisible(true);            
           }
            else if(archiveFile.isFile() == true || archiveFile.getName() == null || archiveFile.getName().equals(""))
            {
                JOptionPane.showMessageDialog(null, "You have not selected an archive file", "Error", JOptionPane.ERROR_MESSAGE);
                chooseArchive(archiveFile, field1, label1, label2);
            }
        }
        catch(NullPointerException npe)
        {
            
        }
    }
    
}
