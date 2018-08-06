package denisluizgoncalves;

import org.junit.Test;

import denisluizgoncalves.anobissexto.MainActivity;

import static org.junit.Assert.*;

public class MainActivityTest {

    @Test
    public void verificaAnoBissextoVerdadeiro(){
        int input = 1732;
        boolean expected = true;
        boolean output;

        MainActivity mainActivity = new MainActivity();
        output =  mainActivity.verificaAnoBissexto(input);
        assertEquals(expected, output);
    }
    @Test
    public void verificaAnoBissextoFalso(){
        int input = 2011;
        boolean expected = false;
        boolean output;

        MainActivity mainActivity = new MainActivity();
        output =  mainActivity.verificaAnoBissexto(input);
        assertEquals(expected, output);
    }
}