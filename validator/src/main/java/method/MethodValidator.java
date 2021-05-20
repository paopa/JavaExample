package method;

import javax.validation.*;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;

@SupportedValidationTarget(value = ValidationTarget.PARAMETERS)
public class MethodValidator implements ConstraintValidator<MethodConstraint, Object[]> {
    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        Arrays.stream(value).forEach(System.out::println);
        return false;
    }
}

@Constraint(validatedBy = MethodValidator.class)
@Target(value = {ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@interface MethodConstraint {
    String message() default "method validation message";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

/**
 * validateParameters() and validateReturnValue() for method validation
 * validateConstructorParameters() and validateConstructorReturnValue() for constructor validation
 */
class Test {
    public static void main(String[] args) throws Exception {
        Test obj = new Test();
        Method method = Test.class.getMethod("method", String.class, String.class);
        Validation.buildDefaultValidatorFactory()
                .getValidator().forExecutables()
                .validateParameters(obj, method, new Object[]{"xxx","yyy"})
                .forEach(s -> System.out.println(s.getMessage()));
    }

    @MethodConstraint
    public void method(String x, String y) {
        System.out.println("method");
    }
}
