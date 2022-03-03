package be.vdab.validation.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

//@Prijs mag voorkomen in een BigDecimal variabele
public class PrijsValidator implements ConstraintValidator<Prijs, BigDecimal> {
    //gebruik valt  buiten de cursus
    @Override
    public void initialize(Prijs constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    //hier bepaal je de voorwaarden voor je bean validation
    @Override
    public boolean isValid(BigDecimal value, ConstraintValidatorContext constraintValidatorContext) {
        //Null is ok, anders gebruik je @NotNull
        if (value == null) {
            return true;
        }
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            return false;
        }
        var aantalCijfersNaKomma = value.scale();
        if (aantalCijfersNaKomma > 2) {
            return false;
        }
        //incl. na de komma
        var totaalAantalCijfers = value.precision();
        //aantal cijfers voor de komma <= 7
        return totaalAantalCijfers - aantalCijfersNaKomma <= 7;
    }
}
