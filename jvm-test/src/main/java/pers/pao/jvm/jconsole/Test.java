package pers.pao.jvm.jconsole;

/**
 * 使用 jdk tool jconsole 去看 jvm 起了多少個 threads
 */
public class Test {
    public static void main(String[] args) throws Exception{
        while(true){
            System.out.println("st");
            Thread.sleep(10000);
            System.out.println("sl");
        }
    }
}
