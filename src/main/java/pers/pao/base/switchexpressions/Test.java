package pers.pao.base.switchexpressions;

public class Test {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        String s = "DOG";
        switch (s) {
            case "DOG":
                System.out.println(s + "!");
                break;
            case "CAT":
                System.out.println(s + "#");
                break;
            default:
                System.out.println("NO~NO~");
        }
    }

    private static void test2() {
        String s = "DOG";
        switch (s) {
            case "DOG" -> System.out.println(s + "!");
            case "CAT" -> System.out.println(s + "#");
            default -> System.out.println("NO~NO~");
        }
    }
}
