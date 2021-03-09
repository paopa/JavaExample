package pers.pao.base.timestamp;

import java.sql.Timestamp;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        System.out.println(new Timestamp(new Date(System.currentTimeMillis()).getTime()).getTime());
    }
}
