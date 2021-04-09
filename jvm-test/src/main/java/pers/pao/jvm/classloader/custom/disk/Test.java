package pers.pao.jvm.classloader.custom.disk;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.util.Objects.isNull;

public class Test {
    public static void main(String[] args) {
        DiskClassLoader loader = new DiskClassLoader(System.getProperty("user.dir") + "/jvm-test/src/resource");
        try {
            Class c = loader.loadClass("pers.pao.jvm.classloader.custom.disk.A");
            if (!isNull(c)) {
                try {
                    Object obj = c.getDeclaredConstructor().newInstance();
                    Method method = c.getDeclaredMethod("say", null);
                    method.invoke(obj, null);
                    Method method2 = c.getDeclaredMethod("x", null);
                    method2.invoke(obj, null);
                } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}