package pers.pao.jvm.classloader.test;

public class Test {
    public static void main(String[] args) throws Exception{
        //get bootstrap class loader from java core library
        System.out.println(Class.forName("java.lang.String").getClassLoader());

        //get system class loader
        System.out.println(Thread.currentThread().getContextClassLoader());

        //get platform class loader
        System.out.println(ClassLoader.getSystemClassLoader().getParent());

    }
}
