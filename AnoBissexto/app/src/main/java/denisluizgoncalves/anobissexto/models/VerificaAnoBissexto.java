package denisluizgoncalves.anobissexto.models;

public class VerificaAnoBissexto {
    private int ano;


    public VerificaAnoBissexto( int ano){

        if(ano <0 )
            throw new IllegalArgumentException("Não existe ano negativo");
        this.ano = ano;
    }
    public int getAno() {
        return ano;
    }

    public boolean verificaAnoBissexto(){

        if((this.ano % 400 == 0)||(this.ano % 4 == 0 && this.ano % 100 != 0 ))
        {
            return true;
        }
        return false;
    }
}
