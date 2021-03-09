package pers.pao.jvm.parent.delegation.mechanism;

/**
 * jvm parent delegation mechanism
 * 當一個 class 需要被載入時 將一層層提交
 * 從 system class loader -> platform class loader -> bootstrap class loader
 * 當不屬於該 class loader 去進行載入 則會都還給下面去做
 *
 * 可以避免如果有一個 自定義 java.lang.String class
 * 這種情境則最後會由 bootstrap 去進行載入 但是載入的會是
 * java 提供的真正 java.lang.String class
 * 而不是 user-defined class
 */
public class Test {
    public static void main(String[] args) {
        String s = new String();
        System.out.println("123");

        Test test = new Test();
        System.out.println(test.getClass().getClassLoader());
    }
}
