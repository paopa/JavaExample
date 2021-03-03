package pers.pao.base.extend.variable;

import com.google.gson.Gson;

import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Map<String, Object> map = generate();
        Gson gson = new Gson();
        A a = gson.fromJson(gson.toJson(map), A.class);
        System.out.println("break");
    }

    private static Map<String, Object> generate() {
        Gson gson = new Gson();
        return Map.ofEntries(
                Map.entry("c", "cc"),
                Map.entry("a", "aa"),
                Map.entry("b", "bb"),
                Map.entry("cO", gson.fromJson(gson.toJson(new C()), C.class))
        );
    }
}

class A extends B {
    private String c;
    private C cObj;
}

class B {
    private String a;
    private String b;
}

class C {
    private String c;
}