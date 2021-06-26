package pers.paopa.junit.runner.params;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import pers.paopa.junit.runner.params.sut.Calculator;
import pers.paopa.junit.runner.params.sut.Issue;

@RunWith(JUnitParamsRunner.class)
public class CalculatorTest {

    @Test
    @Parameters(value = {"0,0,0,print1,true", "1|1|2|print2|false"})
    @TestCaseName("test case 1 -> a:{0}, b:{1}, sum:{2}, print:{3}, bool:{4}")
    public void testCase1(int a, int b, int sum, String print, boolean bool) {
        Calculator calculator = new Calculator();
        int actual = calculator.add(a, b);
        System.out.println(print + ", " + bool);
        Assertions.assertThat(actual).isEqualByComparingTo(sum);
    }

    @Test
    @Parameters(method = "testAddData")
    public void testCase2(Issue issue, int second, int expected) {
        Calculator calculator = new Calculator();
        int actual = calculator.add(issue.getId(), second);
        Assertions.assertThat(actual).isEqualByComparingTo(expected);
    }

    /**
     * create a method and return data array
     */
    private Object[] testAddData() {
        return new Object[]{
                new Object[]{new Issue(1), 2, 3},
                new Object[]{new Issue(5), 10, 15},
        };
    }

    @Test
    @FileParameters("src/main/resources/junit-params-test-parameters.csv")
    public void testCase3(int first, int second, int expected) {
        Calculator calculator = new Calculator();
        int actual = calculator.add(first, second);
        Assertions.assertThat(actual).isEqualByComparingTo(expected);
    }

}
