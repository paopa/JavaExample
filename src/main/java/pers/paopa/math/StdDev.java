package pers.paopa.math;

import java.util.ArrayList;
import java.util.List;

public class StdDev {
    public static void main(String[] args) {
        Long[] x = {31L, 45L, 10L, 31L, 45L, 10L, 14L, 10L, 31L, 45L, 10L, 14L, 14L};
        Long sum = 0L;
        for (Long value : x) {
            sum = sum + value;
        }
        System.out.println(sum);
        Long avg = sum / x.length;
        System.out.println(avg);
        List<Double> temp = new ArrayList<>();
        Double tempSum = 0D;
        for (Long value : x) {
            temp.add(Math.pow((value - avg), 2));
            tempSum = tempSum + Math.pow((value - avg), 2);
        }
        System.out.println(temp);
        System.out.println(tempSum);
        Double end = Math.sqrt(tempSum / (x.length - 1));
        System.out.println(end);
    }
}
