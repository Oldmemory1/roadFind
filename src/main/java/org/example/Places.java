package org.example;

import lombok.Getter;
import org.example.entity.Transfer;
import org.example.entity.regionTransfer;

import java.util.*;
@Getter
public class Places {
    /*图节点连接情况*/
    private List<Transfer> transferList=new ArrayList<>();
    /*一地区对一个set*/
    private List<regionTransfer> regionTransferList=new ArrayList<>();


    public Places(List<Transfer> transferList){
        this.transferList=transferList;

    }
    public void calc(){
        Set<String> region=new HashSet<>();
        for (Transfer transfer : transferList) {
            region.add(transfer.getFrom());
        }
        for (String s : region) {
            regionTransferList.add(new regionTransfer(s));
        }
        System.out.println(region.size());
        System.out.println(regionTransferList.size());
    }
    public void f(int place,String startRegionName,int regionTransferListPlace,int BasePlace){
        for(int j=place/*交通表的开始位置*/;j<transferList.size();j++){
            if(transferList.get(j).getFrom().equals(startRegionName)){
                int place1=transferList.get(j).getNumber();
                regionTransferList.get(regionTransferListPlace).addPlace(transferList.get(j).getTo());
                regionTransferList.get(BasePlace).addPlace(transferList.get(j).getTo());
                String to=transferList.get(j).getTo();
                int place2=0;
                for(int k1=0;k1<regionTransferList.size();k1++){
                    if(regionTransferList.get(k1).getFrom().equals(to)){
                        place2=k1;
                        break;
                    }
                }
                f(place1,to,place2,BasePlace);
            }
        }
    }
    public void transfer() {
        for (int i = 0; i < regionTransferList.size(); i++) {
            String regionName = regionTransferList.get(i).getFrom();

            f(0,regionName,i,i);
            /*for(int j=place;j< transferList.size();j++){
                if(transferList.get(j).getFrom().equals(regionName)){
                    final int place1=transferList.get(j).getNumber();
                    regionTransferList.get(i).addPlace(transferList.get(j).getTo());
                    String to=transferList.get(j).getTo();
                    //找到去的位置，然后去的位置开始，找路线表里面第一个，但是要大于place1
                    int place2=0;
                    for(int k1=0;k1<regionTransferList.size();k1++){
                        if(regionTransferList.get(k1).getFrom().equals(to)){
                            place2=k1;
                            break;
                        }
                    }
                    for(int k=place1;k<transferList.size();k++){
                        if(transferList.get(k).getFrom().equals(to)){
                           final int place3=transferList.get(k).getNumber();
                           regionTransferList.get(place2).addPlace(transferList.get(k).getTo());
                           String to1=transferList.get(k).getTo();
                           int place4=0;
                           for (int k2=0;k2<regionTransferList.size();k2++){
                               if(regionTransferList.get(k2).getFrom().equals(to1)){
                                   place4=k2;
                                   break;
                               }
                           }
                           for(int k3=place4;k3< transferList.size();k3++){
                               if(transferList.get(k3).getFrom().equals(to1)){
                                   final int place5=transferList.get(k3).getNumber();
                                   regionTransferList.get(place4).addPlace(transferList.get(k3).getTo());
                                   String to2=transferList.get(k3).getTo();

                               }
                           }

                        }
                    }


                }
            }


        }*/


        }
    }

}
