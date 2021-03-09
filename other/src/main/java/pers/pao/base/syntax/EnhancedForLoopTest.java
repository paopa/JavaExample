package pers.pao.base.syntax;

import java.util.List;

/**
 * 從 byte code 或是 compile 來看 可以發現
 * enhanced for loop 是藉由 iterator 來實現的
 * 由此可知，只要實現 iterator 就可以使用 enhanced for loop
 */
public class EnhancedForLoopTest {
    public static void main(String[] args) {
        List list = null;
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
