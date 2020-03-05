import javax.swing.*;
import java.util.ArrayList;
/**
 * Este es un juego tradicional de damas chinas
 * 
 * @author (Felipe Marin) 
 * @version (1.0)
 */
public class Checkers
{
    private int width;
    private int x;
    private Tablero tableroJuego;
    private Tablero tableroConfig;
    private ArrayList <Fichas> fichas;
    private String tabActual;
    private boolean white;
    private boolean king;
    /**
     * Constructor for objects of class Checkers
     */
    public Checkers(int width)
    {
        tableroJuego = new Tablero(width,20,20);
        tableroConfig = new Tablero(width,20,400);
        tabActual = "config";
        fichas = new ArrayList <Fichas>();
        
    }

    /**
     * Adiciona fichas nuevas a los tableros.
     * @param  int[][]men  la lista de las posiciones donde deben ir las fichas.
     */
    public void add(boolean white, int[][] men)
    {
        tableroConfig.addFichas(white, men);
    }
    /**
     * Agrega una nueva ficha en la posicion dada y si es rey o no
     * @param boolean white indica que judaro es, si es blanco o negro
     * @param boolean king indica si es rey u hombre
     * @param int row indica la fila en donde se añadirá
     * @param int column indica la columna en donde se añadirá
     */
    public void add(boolean white,boolean king, int row, int column){
        if(isTableroConfig()){
            tableroConfig.addFicha(white, king, row, column);
            this.white=white;
            this.king=king;
        }
        else{
            JOptionPane.showMessageDialog(null,"Solo se pueden adicionar fichas en tablero de configuración");
            }
    }
    /**
     * Nos da el numero de la posicion donde se encuentra la ficha
     * @return retorna un arreglo de listas de tipo Ficha
     */
    public ArrayList <Fichas> getFichas(){
        return fichas; 
    }
    /**
     * Elimina una matriz de fichas
     * @param int[][] pieces la lista de las posicion en donde se quitan las fichas
     */
    public void remove(int[][] pieces){
        tableroConfig.removeFichas(pieces);
    }
    /**
     * Elimina una ficha, ya sea rey u hombre
     * @param int row la fila donde se removera
     * @param int column la columna donde se removera
     */
    public void remove(int row, int column){
        if (isTableroConfig()){
            tableroConfig.removeFicha(row,column);
        }
        else{
            JOptionPane.showMessageDialog(null,"No puede eliminar una ficha estando en tablero de juego.");
        }
    }
    private boolean isTableroConfig(){
        if(tabActual.equals("juego")){
            return false;
        }
        else{
            return true;
        }
    }
    public void makeVisible(){
        tableroJuego.makeVisible();
        tableroConfig.makeVisible();
    }
    public void makeInvisible(){
        tableroJuego.makeInvisible();
        tableroConfig.makeVisible();
    }
    /**
     * Selecional las casillas cercanas a la ficha
     * @param int row son las filas
     * @param int column son las columnas
     */
    public void select(int row, int column){
        if(!tabActual.equals("juego")){
            JOptionPane.showMessageDialog(null,"No puede realizar movimientos en tablero de configuración");
        }
        else{
            tableroJuego.select(row, column);
        }
    }
    
    private void actualiceTablero(ArrayList <ArrayList<Fichas>> fichas,String modo){
        for(int i=0;i<fichas.size();i++){
            for(int j=0;j<fichas.get(i).size();j++){
                if(fichas.get(i).get(j)!=null){
                    if(modo.equals("juego")){
                       if(fichas.get(i).get(j).getTipo().equals("king")){//getTipo me dice si es king o no
                            if(fichas.get(i).get(j).getColor().equals("magenta")){
                                tableroJuego.addFicha(true,true,i+1,j+1); 
                            }
                            else{
                                tableroJuego.addFicha(false,true,i+1,j+1); 
                            }    
                        }
                       else{
                           if(fichas.get(i).get(j).getColor().equals("blue")){
                               tableroJuego.addFicha(true,false,i+1,j+1);
                            }
                            else{
                                tableroJuego.addFicha(false,false,i+1,j+1);
                            }
                        }
                    }  
                }
            }
        }
    }
    
    public void swap(){
        if (tabActual.equals("config")){
            tabActual="juego";
            actualiceTablero(tableroConfig.getFichas(),"juego");
            
            tableroConfig.madeASwap();
            tableroJuego.makeVisible();
        }
        else{
            tabActual="config";
            actualiceTablero(tableroJuego.getFichas(),"config");
            tableroJuego.madeASwap();
            tableroConfig.makeVisible();
        }
    }
    public String queTableroEs(){
        return tabActual;
    }
    /**
     * Saca al usuario del juego
     */
    public void finish(){
        System.exit(0);
    }
    
}
