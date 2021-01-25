package pers.paopa.exception.simple;

import com.google.common.base.Throwables;

/**
 * Exception class toString() is extend from Throwable
 */
public class ToStringTest {
    public static void main(String[] args) {
        try{
            Integer.valueOf("zxcv");
        }catch (Exception e){
//            System.out.println(e);
            System.out.println(Throwables.getStackTraceAsString(e));
        }
    }
}
