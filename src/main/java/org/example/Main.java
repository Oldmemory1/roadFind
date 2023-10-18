package org.example;

import org.example.Configuration.MainConfiguration;
import org.example.component.roadsList;
import org.example.window.MainWindow;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
       //roadsList list=new roadsList("outcomes.txt");

        new MainWindow();
    }
}