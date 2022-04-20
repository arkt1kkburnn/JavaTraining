package org.nikita.people;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;

public class Jframe {
    JFrame jf;
    Campus campus = new Campus();
    json json = new JsonImpl();
    ReadCommand command = new ReadCommand();
    public Jframe(){
        jf = new JFrame();
        JPanel jp = new JPanel();
        JButton b = new JButton("Read");
        b.setBounds(100,100,100,40);
        String[] column = {"Name","Fathername","Surname","Inn","Birthdate","Joindate"};
        DefaultTableModel dtm = new DefaultTableModel(column,0);
        command.exe();
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               for (int i=0;i<command.sep1.length;i++){
                   dtm.addRow(command.sep1[i]);
               }
           }
        });
        JTable jt = new JTable(dtm);
        jt.setBounds(30,40,200,300);
        JScrollPane sp = new JScrollPane(jt);
        jp.add(sp);
        jp.add(b);
        jf.add(jp);
        jf.setSize(300,400);
        jf.setVisible(true);
    }

}
