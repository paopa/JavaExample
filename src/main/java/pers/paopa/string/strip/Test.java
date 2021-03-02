package pers.paopa.string.strip;

public class Test {
    public static void main(String[] args) {
        String x = "Sanchez, Nguyen and Harrell                                                                                                                                                                             ";
        String strip = x.strip();
        System.out.printf("%s %s\t", x.length(), x);
        System.out.printf("%s %s\n", strip.length(), strip);

    }
}
