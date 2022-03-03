package be.vdab.validation.constraints;

import be.vdab.validation.domain.Product;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//annotatie mag in de Product class voorkomen
public class VerkoopPrijsAankoopPrijsValidator implements ConstraintValidator<VerkoopPrijsAankoopPrijs, Product> {
    @Override
    public void initialize(VerkoopPrijsAankoopPrijs constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Product product, ConstraintValidatorContext constraintValidatorContext) {
        //null controle gebeurt niet hier, dus null is ok, dit is ook bij andere annotaties zoals @Min, @Max, etc. het geval
        if (product == null) {
            return true;
        }
        if (product.getVerkoopPrijs() == null || product.getAankoopPrijs() == null) {
            return false;
        }
        return product.getVerkoopPrijs().compareTo(product.getAankoopPrijs()) >= 0;
    }
}
