package pers.pao.jvm.stack.frame.binding.invoke;

public class Test {
    public static void main(String[] args) {
        Son son = new Son();
        son.show();

        // declare a super class variable
        Father f = son;
        f.showCommon();
    }
}

class Father {
    public Father() {
        System.out.println("father contructor");
    }

    public static void showStatic() {
        System.out.println("father show static");
    }

    public final void showFinal() {
        System.out.println("father show final");
    }

    public void showCommon() {
        System.out.println("father show common");
    }
}

class Son extends Father {

    public Son() {
        super();
    }

    public Son(int x) {
        this();
    }

    public static void showStatic() {
        System.out.println("son show static");
    }

    private void showPrivate() {
        System.out.println("son show private");
    }

    public void showCommon() {
        System.out.println("son show common");
    }

    public void show() {
        Father.showStatic();// invokestatic
        super.showFinal();// invokespecial
        super.showCommon();// invokespecial
        showStatic();// invokestatic
        showPrivate();// invokevirtual , before java 11 using invokespeical
        this.showFinal();// invokevirtual
        this.showCommon();// invokevirtual
        IMethod iMethod = () -> System.out.println("interface method"); // invokedynamic
        iMethod.method();// invokeinterface
    }
}

interface IMethod {
    void method();
}
