package pers.pao.exception.simple;

/**
 * Exception class toString() is extend from Throwable
 */
public class ToStringTest
{
    public static void main(String[] args)
    {
        try {
            Integer.valueOf("zxcv");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
