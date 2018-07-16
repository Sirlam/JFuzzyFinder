/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jfuzzyfinderapp;

import javax.swing.JOptionPane;

/**
 *
 * @author Olanrewaju-PC
 */
public class JFuzzyFinderApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            sleepThread();
        
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run()
            {
                new Home().setVisible(true);
            }
        });
    }
     private static void sleepThread()
    {
        try{
            Thread.sleep(4000);
        }
        catch(InterruptedException exp)
        {
            JOptionPane.showMessageDialog(null, "Error Starting App", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
