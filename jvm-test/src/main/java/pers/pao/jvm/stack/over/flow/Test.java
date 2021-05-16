package pers.pao.jvm.stack.over.flow;

/**
 * 實現 StackOverflowError
 *
 * @link https://docs.oracle.com/en/java/javase/11/tools/java.html#GUID-3B1CE181-CD30-4178-9602-230B800D4FAE
 * 設置 java stack size : -Xss
 * <p>
 * default conut: 18801
 * 實驗設定 stack size -Xss256k count: 2839
 */
public class Test {
    private static int count = 1;

    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }
}
