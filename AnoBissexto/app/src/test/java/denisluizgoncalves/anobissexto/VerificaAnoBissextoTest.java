package denisluizgoncalves.anobissexto;

import org.junit.Assert;
import org.junit.Test;
import denisluizgoncalves.anobissexto.models.VerificaAnoBissexto;

public class VerificaAnoBissextoTest {
    @Test(expected = IllegalArgumentException.class)// espera um argumento ilegal que foi colocado no construtor
    public void verificaAnoNegativo(){
        VerificaAnoBissexto ano = new VerificaAnoBissexto(-15);

    }
    @Test
    public void verificaAnoNaoBissexto(){
        VerificaAnoBissexto ano = new VerificaAnoBissexto(1742);
        boolean resultado = ano.verificaAnoBissexto();
        Assert.assertFalse(resultado);

    }
    @Test
    public void verificaAnoBissextoVerdadeiro(){
        VerificaAnoBissexto ano = new VerificaAnoBissexto(1600);
        boolean resultado = ano.verificaAnoBissexto();
        Assert.assertTrue(resultado);
    }
}