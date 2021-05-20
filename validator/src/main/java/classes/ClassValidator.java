package classes;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

public class ClassValidator implements ConstraintValidator<ClassConstraint, Object> {

    String field1;
    String field2;

    @Override
    public void initialize(ClassConstraint constraintAnnotation) {
        this.field1 = constraintAnnotation.field1();
        this.field2 = constraintAnnotation.field2();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        System.out.println("field1: " + field1);
        System.out.println("field2: " + field2);
        return false;
    }
}

@Constraint(validatedBy = ClassValidator.class)
@Target(value = {ElementType.TYPE, ElementType.TYPE_USE})
@Retention(value = RetentionPolicy.RUNTIME)
@interface ClassConstraint {
    String message() default "class validator message";

    String field1();

    String field2();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

@ClassConstraint(field1 = "x", field2 = "y")
@RequiredArgsConstructor
class A {
    private final String x;
    private final String y;
}

@RequiredArgsConstructor
class B {
    private final List<@ClassConstraint(field1 = "x", field2 = "y") A> list;
}

class Test {
    public static void main(String[] args) {
        Validation.buildDefaultValidatorFactory()
                .getValidator().validate(new B(List.of(new A("xx", "yy"))))
//                .getValidator().validate(new A("x1", "y1"))
                .forEach(s -> System.out.println(s.getMessage()));
        System.out.println("thread end");
    }
}
