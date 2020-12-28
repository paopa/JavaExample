package pers.paopa.string.encode;

public class Test {
    public static void main(String[] args) throws Exception {
        test1();

    }

    private static void test1() throws Exception {
        String s = "我我";
        byte[] bytes = s.getBytes("UTF-8");

        String current = new String(bytes, "UTF-16");
        System.out.println("error decode: " + current);

        String error = new String(bytes, "UTF-8");
        System.out.println("current decode: " + error);
    }
}
