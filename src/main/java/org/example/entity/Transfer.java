package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
/*图的节点*/
public class Transfer {
    private int number;
    private String from;
    private String to;
    public Transfer(int number, String from, String to) {
        this.number = number;
        this.from = from;
        this.to = to;
    }
}
