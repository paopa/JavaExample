package pers.pao.jvm.classloader.get;

public class Test {
    public static void main(String[] args) throws Exception{

        // 從 class 取得 class loader
        System.out.println(Class.forName("java.lang.String").getClassLoader());

        // 從當前 thread 的 class 獲得 class loader
        System.out.println(Thread.currentThread().getContextClassLoader());

        // 通過 ClassLoader 去取得 class loader
        System.out.println(ClassLoader.getSystemClassLoader().getParent());

    }
}
