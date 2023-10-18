package org.example.Configuration;

import lombok.SneakyThrows;
import org.apache.ibatis.io.Resources;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.example.component.*;

import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan("org.example.component")
public class MainConfiguration {
    @Bean
    @SneakyThrows
    public String fileName(){
        Properties properties=new Properties();
        properties.load(Resources.getResourceAsStream("file.properties"));
        return properties.getProperty("fileName");
    }
    @Bean
    public roadsList roadsList(@Qualifier("fileName") String fileName) throws IOException {
        return new roadsList(fileName);
    }

}
