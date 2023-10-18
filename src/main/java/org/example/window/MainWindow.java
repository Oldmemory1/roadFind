package org.example.window;

import com.mysql.cj.exceptions.CJOperationNotSupportedException;
import lombok.extern.java.Log;
import org.example.Configuration.MainConfiguration;
import org.example.Places;
import org.example.component.roadsList;
import org.example.entity.regionTransfer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Log
public class MainWindow extends JFrame {
    public MainWindow(){
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(org.example.Configuration.MainConfiguration.class);
        roadsList list=context.getBean(roadsList.class);
        Places places=new Places(list.getRotes());
        places.calc();
        places.transfer();
        List<regionTransfer> regionTransferList=places.getRegionTransferList();
        //System.out.println(places.getRegionTransferList());
        JFrame frame=new JFrame("Title");
        Container container=frame.getContentPane();
        frame.setSize(800,800);
        frame.setVisible(true);
        JTextArea textArea=new JTextArea();
        textArea.setBounds(50,50,400,50);
        container.add(textArea);
        JButton button=new JButton("查看通往的地区");
        button.setBounds(50,150,200,50);
        container.add(button);
        frame.setLayout(null);
        frame.setBackground(Color.white);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text=textArea.getText();
                for(int i=0;i<regionTransferList.size();i++){
                    if(text.equals(regionTransferList.get(i).getFrom())){
                        log.info(regionTransferList.get(i).getTo().toString());
                        Set<String> set= regionTransferList.get(i).getTo();
                        StringBuilder stringBuilder=new StringBuilder();
                        Iterator<String> iterator=set.iterator();
                        while (iterator.hasNext()){
                            stringBuilder.append(iterator.next()).append('\n');
                        }
                        new SubWindow(stringBuilder.toString());
                    }
                }
            }
        });
    }
}
