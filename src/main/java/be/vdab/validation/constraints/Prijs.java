package be.vdab.validation.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Digits;
import javax.validation.constraints.PositiveOrZero;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
//beschikbaar tijdens lopen van prog -- bij SOURCE neemt de compiler de annotation niet op in de bytecode
@Retention(RetentionPolicy.RUNTIME)
//@Constraint(validatedBy = {})
@Constraint(validatedBy = PrijsValidator.class)
//@PositiveOrZero
//@Digits(integer = 7, fraction = 2)
public @interface Prijs {
    //dit is een annotation parameter (lijkt op method syntax), je kan een parameter message meegeven,
    //hier wordt default waarde ingesteld, de message parameter bepaalt de key van de foutboodschap, die Spring opzoekt in messages.properties
    String message() default "{be.vdab.Prijs.message}";
    //2 andere parameters, gebruik hiervan valt buiten de cursus
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
