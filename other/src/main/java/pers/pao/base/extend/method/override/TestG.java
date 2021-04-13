package pers.pao.base.extend.method.override;

import java.util.concurrent.atomic.AtomicInteger;

public class TestG {
    public static void main(String[] args) {
        AA a = new BB("12","da","13");
        BB b = (BB) a;
        System.out.println(((AA)a).getId());
        System.out.println(b.getId());

    }
}

abstract class AA {
    private String id;
    private String name;
    private String num;

    public AA(String name, String num) {
        this.id = String.valueOf(new AtomicInteger(10000).getAndAdd(1));
        this.name = name;
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }

    public abstract void setNum(String num);
}

class BB extends AA {

    private String id;
    private String name;
    private String num;

    public BB(String id, String name, String num) {
        super(name, num);
        this.id = id;
        this.name = name;
        this.num = num;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getNum() {
        return num;
    }

    @Override
    public void setNum(String num) {
        this.num = num;
    }
}
