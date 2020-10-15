package pers.paopa.stream;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        demo();
//        List<String> a = new ArrayList<>();
//        List<String> b = List.of("asd","zxc","cvb","bnm");
//        String d = "zxc";
//        for(String c:b){
//            if(d.equals(c)){
//                a.add(c);
//            }
//        }

//        a = b.stream().filter(c -> d.equals(c)).collect(Collectors.toList());
//        System.out.println(a);
    }

    private static void demo() {
        List<String> a = Stream.of("abc", "ggh","biic","wer").collect(Collectors.toList());
        a.stream()
                .map(aaa -> {
                    System.out.println(aaa.toUpperCase());
                    return aaa;
                })
                .filter(aaa -> aaa.equals("biic"))
                .map(aaa -> {
                    try {
                        throw new Exception("123");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return aaa;
                })
                .findFirst();

        System.out.println(123);

    }
}
