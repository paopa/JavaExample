package pers.pao.jvm.classloader.category.platform;

import jdk.security.jarsigner.JarSignerException;

public class Test {
    public static void main(String[] args) {
        System.out.println(Test.class.getClassLoader().getParent());
        System.out.println(JarSignerException.class.getClassLoader());
    }
}
