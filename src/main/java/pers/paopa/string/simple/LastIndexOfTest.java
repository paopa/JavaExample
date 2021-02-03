package pers.paopa.string.simple;

public class LastIndexOfTest {
    public static void main(String[] args) {
        String a = "abc/123/ggg";
        System.out.println(a.lastIndexOf("/"));
        System.out.println(a.substring(0, a.lastIndexOf("/")));
    }
}
