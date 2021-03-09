package pers.pao.array.error;

import java.util.ArrayList;
import java.util.List;

public class IndexOutOfBound {
    public static void main(String[] args) {

        String[] x = {"1", "2", "3", "4"};
        System.out.println(x[0]);

        List<String> y = new ArrayList();
        System.out.println(y.size());
    }
}
