package be.vdab.validation.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
//TYPE staat toe om de annotation te typen voor een class
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
//schrijf hier de logica om te valideren
@Constraint(validatedBy = VerkoopPrijsAankoopPrijsValidator.class)
public @interface VerkoopPrijsAankoopPrijs {
    String message() default "{be.vdab.VerkoopPrijsAankoopPrijs.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
