

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CheckersTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CheckersTest
{
    /**
     * Default constructor for test class CheckersTest
     */
    public CheckersTest()
    {
    }

    @Test
    public void lasfichasnosepuedensalirdeltableroDL()
    {
        Checkers checkers1 = new Checkers(8);
        checkers1.add(true, false, 2, 3);
        checkers1.select(2, 3);
        //checkers1.shift(true, true);
        //checkers1.shift(true, true);
    }

    @Test
    public void deberiaguardaryrecuperartableroDL()
    {
        Checkers checkers1 = new Checkers(8);
        checkers1.add(true, false, 2, 3);
        checkers1.add(false, true, 3, 4);
        //checkers1.save("esto es una prueba");
        checkers1.remove(2, 3);
        checkers1.remove(3, 4);
        //assertEquals("-.-.-.-..-W-.-.--.-w-.-..-.-.-.--.-.-.-..-.-.-.--.-.-.-..-.-.-.-", checkers1.recover("esto es una prueba"));
    }

    @Test
    public void elSaltoFuncionaDL()
    {
        Checkers checkers1 = new Checkers(8);
        checkers1.add(false,false, 2, 3);
        checkers1.swap();
        checkers1.add(true , false,  4, 7);
        checkers1.select(2, 3);
        //checkers1.move("left");
        checkers1.swap();
        checkers1.add(true, true, 3, 4);
        checkers1.add(false,true, 4, 5);
        checkers1.swap();
        checkers1.select(3, 4);
        //checkers1.jump(false, true);
    }

    @Test

    public void deberiaAdicionarFichasEnElTableroDeConfiguracionBL(){
        Checkers tablero=new Checkers(5);
        tablero.add(false,true, 1,2);
        tablero.add(false,false, 2,3);
    }
    @Test
    public void noDeberiaAdicionarFichasEnElTableroDeJuegoBL(){
        Checkers tablero=new Checkers(5);

        tablero.add(false,true, 1,2);

        tablero.add(false,false, 2,3);
        tablero.swap();
        tablero.add(false,true, 5,2);

    }
}


   