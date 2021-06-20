package pers.pao.jvm.stack.frame.return_.address;

public class Test
{
    // using command "return"
    public void methodVoid() {}

    // using command "ireturn"
    public boolean methodBoolean() {return true;}

    // using command "ireturn"
    public byte methodByte() {return 0;}

    // using command "ireturn"
    public char methodChar() {return 0;}

    // using command "ireturn"
    public short methodShort() {return 0;}

    // using command "ireturn"
    public int methodInt() {return 0;}

    // using command "lreturn"
    public long methodLong() {return 0;}

    // using command "freturn"
    public float methodFloat() {return 0f;}

    // using command "dreturn"
    public double methodDouble() {return 0;}

    // using command "areturn"
    public String methodString() {return null;}

    // using command "return"
    static {
    }

    // using command "return"
    {
    }

    public void method1()
            throws Exception
    {
        throw new Exception();
    }

    public void method2()
    {
        try {
            method1();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
