package pers.pao.jvm.classloader.category.bootstrap;

import java.io.EOFException;

/**
 * java 核心類的加載都是為 bootstrap class loader
 */
public class Test {
    public static void main(String[] args) {
        // get boostrap class loader
        System.out.println(EOFException.class.getClassLoader());

    }
}
