package pers.pao.jvm.args;

import java.lang.management.ManagementFactory;
import java.util.Arrays;

/**
 * jvm arguments
 * must have "-D" prefix
 * e.g. -Djvm.args.test=123
 * java command
 * e.g. java -Djvm.args.test=123 pers.pao.jvm.args.Test
 * <p>
 * program arguments
 * e.g 123 ,--program.args.test=123
 * java command
 * e.g.java pers.pao.jvm.args.Test 123 --program.args.test=123
 */
public class Test
{
    public static void main(String[] args)
    {
        ManagementFactory.getRuntimeMXBean().getInputArguments().forEach(System.out::println);
        System.out.println("start program args");
        Arrays.stream(args).forEach(System.out::println);
        System.out.println("*****test get env method*****");
        System.getenv().forEach((x, y) -> System.out.println(x + " | " + y));
    }
}
