package pers.pao.base.syntax;

/**
 * variable of interface is static final
 */
public class InterFaceTest {
    public static void main(String[] args) {
        System.out.println(A.x);
    }
}

class A implements IA{

}

interface IA {
    String x = "x";
}