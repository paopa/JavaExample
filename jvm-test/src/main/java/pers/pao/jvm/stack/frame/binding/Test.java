package pers.pao.jvm.stack.frame.binding;

public class Test {
    public void showAnimal(Animal animal) {
        animal.eat(); // late binding
    }

    public void showHunting(Hunting hunting) {
        hunting.hunt(); // late binding
    }
}

class Animal {
    public void eat() {
        System.out.println("animal eat");
    }
}

interface Hunting {
    void hunt();
}

class Dog extends Animal implements Hunting {
    @Override
    public void eat() {
        System.out.println("dog eat");
    }

    @Override
    public void hunt() {
        System.out.println("dog hunt");
    }
}

class Cat extends Animal implements Hunting {
    public Cat() {
        super(); // early binding
    }

    public Cat(String name) {
        this(); // early binding
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("cat eat");
    }

    @Override
    public void hunt() {
        System.out.println("cat hunt");
    }
}