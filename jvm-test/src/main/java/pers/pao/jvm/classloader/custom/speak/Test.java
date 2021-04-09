package pers.pao.jvm.classloader.custom.speak;

import java.lang.reflect.InvocationTargetException;

import static java.util.Objects.isNull;

public class Test {
    public static void main(String[] args) throws Exception {
        SpeakClassLoader loader1 =
                new SpeakClassLoader(System.getProperty("user.dir") + "/jvm-test/src/resource/classloader/speak/t1");
        SpeakClassLoader loader2 =
                new SpeakClassLoader(System.getProperty("user.dir") + "/jvm-test/src/resource/classloader/speak/t2");
        new Thread(new Context(loader1)).start();
        new Thread(new Context(loader2)).start();
    }

}

class Context implements Runnable {

    public Context(ClassLoader loader) {
        Thread.currentThread().setContextClassLoader(loader);
        System.out.println("Thread " + Thread.currentThread().getName() +
                " classloader: " + Thread.currentThread().getContextClassLoader().toString());
    }

    @Override
    public void run() {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        try {
//            Class c = cl.loadClass("pers.pao.jvm.classloader.custom.speak.SpeakImpl");
            Class c = Class.forName("pers.pao.jvm.classloader.custom.speak.SpeakImpl", true, cl);
            System.out.println(c.getClassLoader().toString());
            if (!isNull(c)) {
//                Object obj = c.getDeclaredConstructor().newInstance();
//                c.getMethod("speak", null).invoke(obj, null);
                ISpeak iSpeak = (ISpeak) c.getDeclaredConstructor().newInstance();
                iSpeak.speak();
            }
        } catch (ClassNotFoundException | NoSuchMethodException
                | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
