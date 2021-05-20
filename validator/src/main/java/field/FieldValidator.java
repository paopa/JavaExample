package field;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.validation.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

/**
 * in the ValidatorFactory will instantiate this class ,
 * so must be a public class
 */
public class FieldValidator implements ConstraintValidator<FieldConstraint, B> {

    @Override
    public boolean isValid(B value, ConstraintValidatorContext context) {
        System.out.println("CustomValidator isValid method get value " + value);
        return false;
    }
}

@Constraint(validatedBy = FieldValidator.class)
@Target(value = {ElementType.FIELD, ElementType.TYPE_USE})
@Retention(value = RetentionPolicy.RUNTIME)
@interface FieldConstraint {
    String message() default "custom validator message";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

@RequiredArgsConstructor
class A {

    private final List<@FieldConstraint B> x;
    private @FieldConstraint B y;
}

@ToString
@Getter
@RequiredArgsConstructor
class B {
    private final String name;
}

class Test {
    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        factory.getValidator().validate(new A(List.of(new B("aaaa"), new B("bbb"))))
                .forEach(s -> System.out.println(s.getMessage()));
        System.out.println("thread end");

    }
}