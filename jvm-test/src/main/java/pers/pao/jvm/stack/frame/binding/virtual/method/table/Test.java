package pers.pao.jvm.stack.frame.binding.virtual.method.table;

/**
 * 在 java 中，override method 會依順序網上找
 * e.g. CockerSpaniel -> Dog -> Object
 * 但如果每次都這樣會照成調用一次都是一個 loop
 * 所以有了 virtual method table 去紀錄對應於哪個 method
 * 會在 class loader sub-system 中 linking step (Resolve stage) 建立 virtual method table
 */
public class Test {

}

interface Friendly {
    void sayHello();

    void sayGoodbye();
}

class Dog {
    public void sayHello() {
    }

    public String toString() {
        return "Dog";
    }
}

class Cat implements Friendly {

    public void eat() {
    }

    @Override
    public void sayHello() {

    }

    @Override
    public void sayGoodbye() {

    }

    public String toString() {
        return "Cat";
    }

    protected void finalize() {

    }
}

class CockerSpaniel extends Dog implements Friendly {

    public void sayHello() {
        super.sayHello();
    }

    @Override
    public void sayGoodbye() {

    }
}


