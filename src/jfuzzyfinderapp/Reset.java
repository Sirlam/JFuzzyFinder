/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jfuzzyfinderapp;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Olanrewaju-PC
 */
public class Reset {
    public void resetall(JTextField field1, JTextField field2, JTable table1, JTable table2,
            JLabel label1, JLabel label2, JLabel label3)
    {
        field1.setText("");
        field2.setText("");
        table1.removeAll();
        table1.repaint();
        DefaultTableModel dtm = (DefaultTableModel)table1.getModel();
        dtm.fireTableDataChanged();
        dtm.setNumRows(0);
        dtm.setNumRows(1024);
        table2.removeAll();
        table2.repaint();
        DefaultTableModel dtm2 = (DefaultTableModel)table2.getModel();
        dtm2.fireTableDataChanged();
        dtm2.setNumRows(0);
        dtm2.setNumRows(1024);
        label1.setText("Total Number of Files = ");
        label2.setText("Archive Size = ");
        label3.setText("Last Modified = ");
    }
}
