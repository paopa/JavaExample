package pers.pao.annotation;

import java.lang.annotation.*;

public class AnnotationTest {

    @SimpleAnnotation()
    private String value = null;

    public static void main(String[] args) throws NoSuchFieldException {
        SimpleAnnotation xx = AnnotationTest.class.getDeclaredField("value").getAnnotation(SimpleAnnotation.class);
        System.out.println( xx.stringValue());
    }
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface SimpleAnnotation {
    String stringValue() default "test";
}
