package per.pao.practice.guava.primitivetype.booleans;

import com.google.common.primitives.Booleans;

/**
 * 提供的功能大致與 其他 Primitive type 的 class 差不多
 * 這邊只寫幾個其他 class 沒有的 method 做測試
 *
 * @see per.pao.practice.guava.primitivetype.shorts.Test
 * @see per.pao.practice.guava.primitivetype.bytes.Test
 */
public class Test {
    public static void main(String[] args) {
        boolean[] booleans = {true, false, true, false, true, false};
        countTrueTest(booleans);
        compareTest();
    }

    private static void compareTest() {
        System.out.println("true v.s. true: " + Booleans.compare(true, true));
        System.out.println("true v.s. false: " + Booleans.compare(true, false));
        System.out.println("false v.s. false: " + Booleans.compare(false, false));
        System.out.println("false v.s. true: " + Booleans.compare(false, true));
    }

    private static void countTrueTest(boolean[] booleans) {
        System.out.println(Booleans.countTrue(booleans));
    }
}
