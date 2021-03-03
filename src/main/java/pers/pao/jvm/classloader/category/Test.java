package pers.pao.jvm.classloader.category;

public class Test {
    public static void main(String[] args) {

        // get system class loader
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //get extension class loader
        ClassLoader extensionClassLoader = systemClassLoader.getParent();
        System.out.println(extensionClassLoader);

        // get bootstrap class loader but can't get
        ClassLoader bootstrapClassLoader = extensionClassLoader.getParent();
        System.out.println(bootstrapClassLoader);

        // user-defined class 由 system class loader 加載
        ClassLoader classLoader = Test.class.getClassLoader();
        System.out.println(classLoader);

        // core-library of java 由 bootstrap class loader 進行加載
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);
    }
}
