package be.vdab.validation.domain;

import be.vdab.validation.constraints.Prijs;
import be.vdab.validation.constraints.VerkoopPrijsAankoopPrijs;

import javax.validation.constraints.Digits;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@VerkoopPrijsAankoopPrijs
public class Product {
    //niet negatief, max 7 cijfers voor de komma, maximaal 2 decimalen
    //fractie = quotient = resultaat v/e deling... het resultaat v/d deling mag max 2 decimalen bevatten?

    //@PositiveOrZero @Digits(integer = 7, fraction = 2)
    @Prijs
    private BigDecimal aankoopPrijs;
    //@PositiveOrZero @Digits(integer = 7, fraction = 2)
    @Prijs
    private BigDecimal verkoopPrijs;

    public BigDecimal getAankoopPrijs() {
        return aankoopPrijs;
    }

    public void setAankoopPrijs(BigDecimal aankoopPrijs) {
        this.aankoopPrijs = aankoopPrijs;
    }

    public BigDecimal getVerkoopPrijs() {
        return verkoopPrijs;
    }

    public void setVerkoopPrijs(BigDecimal verkoopPrijs) {
        this.verkoopPrijs = verkoopPrijs;
    }
}
