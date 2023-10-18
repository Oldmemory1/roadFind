package org.example.component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.io.Resources;
import org.example.entity.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
@Getter
@Component
@Setter
@ToString
//读入文件用
public class roadsList {
    @Autowired
    @Qualifier("fileName")
    private String fileName;
    private List<Transfer> rotes=new ArrayList<>();
    public roadsList(@Qualifier("fileName")String fileName) throws IOException {
        this.fileName=fileName;
        Scanner scanner=new Scanner(Resources.getResourceAsStream(fileName));

        int num=1;
        while (scanner.hasNextLine()){
            String s=scanner.nextLine();
            s=s.substring(15);
            StringTokenizer tokenizer=new StringTokenizer(s,"→");
            String from="";
            String to="";
            int place=1;
            while (tokenizer.hasMoreTokens()){
                if(place==1){
                    from=tokenizer.nextToken().trim();
                    place++;
                }
                if(place==2){
                    to=tokenizer.nextToken().trim();
                }
            }
            rotes.add(new Transfer(num,from,to));
            num++;
        }
        scanner.close();
    }


}
