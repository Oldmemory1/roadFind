package org.example.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
/*地区通行情况*/
public class regionTransfer {
    private String from;
    private Set<String> to=new HashSet<>();
    public void addPlace(String s){
        to.add(s);
    }
    public regionTransfer(String from){
        this.from=from;
    }
}
