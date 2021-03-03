package pers.pao.jvm.graal;

//import org.graalvm.polyglot.Context;

/**
 * 需要使用 graalVM
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("hello world from java");
//        Context context = Context.newBuilder().allowAllAccess(true).build();
//        context.eval("js", "print('hello world form js')");
//        context.eval("python", "print('hello world from python')");
//        context.eval("ruby", "puts 'hello world from ruby'");
    }
}
