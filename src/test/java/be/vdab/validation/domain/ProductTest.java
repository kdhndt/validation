package be.vdab.validation.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Validator validator;
    private Product product;

    @BeforeEach
    void beforeEach() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        product = new Product();
        product.setAankoopPrijs(BigDecimal.ONE);
        product.setVerkoopPrijs(BigDecimal.TEN);
    }

    @Test
    void correctProduct() {
        //validate geeft een verzameling met fouten
        assertThat(validator.validate(product)).isEmpty();
    }

    //zelf geschreven
    @ParameterizedTest @ValueSource(strings = "1234567.12")
    void correctProduct2(String prijs) {
        product.setVerkoopPrijs(new BigDecimal(prijs));
        assertThat(validator.validate(product)).isEmpty();
    }

    //laatste parameter zelf geschreven
    @ParameterizedTest @ValueSource(strings = {"-1", "-1.234", "12345678", "1.666"})
    //test met verschillende parameters
    void verkeerdeAankoopPrijzen(String prijs) {
        product.setAankoopPrijs(new BigDecimal(prijs));
        assertThat(validator.validate(product)).isNotEmpty();
    }

    @Test
    void aankoopPrijs10EnVerkoopPrijs1IsVerkeerd() {
        product.setAankoopPrijs(BigDecimal.TEN);
        product.setVerkoopPrijs(BigDecimal.ONE);
        assertThat(validator.validate(product)).isNotEmpty();
    }
}