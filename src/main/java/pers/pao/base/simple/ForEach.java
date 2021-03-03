package pers.pao.base.simple;

//import java.util.stream.IntStream;

public class ForEach {
    public static void main(String[] args) {
        for (int i=0;i<10;i++)
            System.out.print(i);

//        IntStream.range(0,10).forEach(i ->System.out.print(i));

        //Use Method Reference
//        IntStream.range(0,10).forEach(System.out::print);
    }
}
