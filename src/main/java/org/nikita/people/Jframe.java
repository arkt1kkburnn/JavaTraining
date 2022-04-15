package org.nikita.people;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;

public class Jframe {
    JFrame jf;
    Campus campus = new Campus();
    json json = new JsonImpl();
    public Jframe(){
        jf = new JFrame();
        JPanel jp = new JPanel();
        //JButton b = new JButton("Apply");
        //b.setBounds(100,100,100,40);
        String j = json.jread("C:/Users/Я/IdeaProjects/MyUniversity1/src/Student.json",campus).toString();
        j = j.substring(17,j.length()-2);
        String[] sep = j.split(",");
        for (int i = 1;i< sep.length;i++){
            sep[i] = sep[i].substring(1);
        }
        //for (String s:sep) s = s.substring(1);
        String[][] sep1 = new String[6][6];
        for (int i = 0;i< sep.length;i++){
            String[] g = sep[i].split(" ");
            sep1[i] = g;
        }
        String[] column = {"Name","Fathername","Surname","Inn","Birthdate","Joindate"};
        JTable jt = new JTable(sep1, column);
        //b.addActionListener(new ActionListener(){
            //public void actionPerformed(ActionEvent e){
                //ObjectMapper mapper = new ObjectMapper();
                //try {
                    //mapper.writeValue(new File("C:/Users/Я/IdeaProjects/MyUniversity1/src/Student.json"),sep1);
                //} catch (Throwable th) {
                   // th.printStackTrace();
                //}
           //}
        //});
        jt.setBounds(30,40,200,300);
        JScrollPane sp = new JScrollPane(jt);
        jp.add(sp);
        //jp.add(b);
        jf.add(jp);
        jf.setSize(300,400);
        jf.setVisible(true);
    }

}
