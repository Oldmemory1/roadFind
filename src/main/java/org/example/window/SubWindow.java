package org.example.window;

import javax.swing.*;
import java.awt.*;

public class SubWindow extends JFrame {
    public SubWindow(String text){
        JFrame frame=new JFrame("查看结果");
        Container container=frame.getContentPane();
        frame.setSize(600,600);
        JTextArea textArea=new JTextArea();
        textArea.setBounds(50,50,300,500);
        textArea.setText(text);
        textArea.setEditable(false);
        container.add(textArea);
        frame.setLayout(null);
        frame.setBackground(Color.WHITE);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
