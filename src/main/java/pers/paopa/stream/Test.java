package pers.paopa.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        List<String> b = List.of("asd","zxc","cvb","bnm");
        String d = "zxc";
//        for(String c:b){
//            if(d.equals(c)){
//                a.add(c);
//            }
//        }

        a = b.stream().filter(c -> d.equals(c)).collect(Collectors.toList());
        System.out.println(a);
    }
}
