import javax.swing.*;
import java.util.ArrayList;
/**
 * La clase tablero crea un rectangulo en el que si pintan las casillas
 * 
 * @author Felipe Marin 
 * @version 1.0
 */
public class Tablero
{
    private int width;
    private int x;
    private int y;
    private ArrayList <ArrayList <Casilla>> juego;
    private ArrayList <ArrayList <Casilla>> zonaJuego;
    private ArrayList <ArrayList <Fichas>> fichas;
    private ArrayList <ArrayList <Fichas>> fichasJuego; 
    
    /**
     * Constructor for objects of class Tablero
     */
    public Tablero(int width,int x, int y)
    {
        this.width = width;
        this.x=x;
        this.y=y;
        fichas = new ArrayList <ArrayList <Fichas>>();
        fichasJuego = new ArrayList <ArrayList <Fichas>>();
        crearTablero();
        crearFichas();
    }
    

    /**
     * Diseña el tablero tomando en cuenta cuantas casillas se quiere crear
     */
    public void crearTablero()
    {
        juego = new ArrayList <ArrayList <Casilla>>();
        int index = 0;
        for (int i=0; i<width;i++){
            ArrayList<Casilla> aux= new ArrayList <Casilla>();
            for (int j=0; j<width;j++){
                Casilla casilla = new Casilla(y+j*(200/8),x+i*(200/8));
                casilla.changeSize(200/8,200/8);
                if((i+j) %2 ==0 ){
                    casilla.changeColor("green");
                }
                else{
                    casilla.changeColor("black");
                }
                index++;
                aux.add(casilla);
            }
            juego.add(aux);
        }
    }
    
    private void crearFichas(){
        ArrayList<Fichas> auxiliar;
        for(int i=0;i<width;i++){
            auxiliar = new ArrayList<Fichas>();
            for(int j=0;j<width;j++){
                auxiliar.add(null);
            }
            fichas.add(auxiliar);
        }
    }
    
    /**
    * Hace visible la matriz de arreglos
    */
    public void makeVisible(){
        for(ArrayList <Casilla> j: juego){
            for (Casilla h:j){
                h.makeVisible();
            }
        }
        // for(ArrayList<Casilla> j: zonaJuego){
            // for (Casilla h:j){
               // h.makeVisible(); 
            // }
        // }
        for(ArrayList<Fichas> f:fichas){
            for(Fichas ficha:f){
                if(ficha!=null)
                    ficha.makeVisible();
            }
        }
        for(ArrayList<Fichas> f:fichasJuego){
            for(Fichas ficha:f){
                if(ficha!=null)
                    ficha.makeVisible();
            }
        }
    }
    /**
    * Hace invisible la matriz de arreglos
    */
    public void makeInvisible(){
        for(ArrayList<Casilla> j: juego){
            for(Casilla h:j){
                h.makeInvisible();
            }
        }
        // for(ArrayList <Casilla> j: zonaJuego){
            // for (Casilla h:j){
                // h.makeInvisible();
            // }
        // }
        for(ArrayList<Fichas> f:fichas){
            for(Fichas ficha:f){
                if(ficha!= null){
                    ficha.makeInvisible();
                }
            }
        }
        for(ArrayList<Fichas> f:fichasJuego){
            for(Fichas ficha:f){
                if (ficha!= null){
                    ficha.makeInvisible();
                }
            }
        }
    }
    public ArrayList <ArrayList<Casilla>> getJuego(){
        return juego;
    }
    public ArrayList <ArrayList<Casilla>> getZonaConfig(){
        return zonaJuego;
    }
    
    /**
     *@param boolean white si el jugador es blanco o negro(player 1 ó player 2)
     *@param  int[][]men lista de las posiciones donde deben ir las fichas.
     */public void addFichas(boolean white, int[][] men){
        ArrayList <Fichas> AuxF= new ArrayList<Fichas>();
        for (int i = 0;i<men.length ; i++){
            System.out.println("this is men: "+men[i][0] + men[i][1]);
            Fichas ficha = new Fichas();
            fichas.get((men[i][0])-1).set((men[i][1])-1,ficha);
            if (white == true){
                ficha.changeColor("blue");
            }
            
            Casilla AuxC = juego.get((men[i][0])-1).get((men[i][1])-1);
            ficha.setDiameter(AuxC.getHeight()); //Me pide la altura de AuxC, que es de tipo Casilla
            ficha.setXPosition(AuxC.getXPosition());
            ficha.setYPosition(AuxC.getYPosition());
        }
        makeVisible();
    }
    
    /**
     * @param boolean white si el jugador es blanco o negro(player 1 ó player 2)
     * @param boolean king si la ficha es rey o no
     * @param int row fila donde se colocará la ficha
     * @param columna columna donde se colocará la ficha
     */public void addFicha(boolean white, boolean king, int row, int column){
        ArrayList <Fichas> temporal = new ArrayList <Fichas>();
        Fichas ficha = new Fichas();
        Casilla AuxC= juego.get(row-1).get(column-1);
        if(white == true){
            ficha.changeColor("blue");
            
            if(king == true){
                ficha.changeColor("magenta");
                ficha.setTipo("king");
            }
        }
        else{
            ficha.changeColor("red");
            
            if(king==true){
                ficha.changeColor("yellow");
                ficha.setTipo("king");
            }
        }
        ficha.setDiameter(AuxC.getHeight()); //Me pide la altura de AuxC, que es de tipo Casilla
        ficha.setXPosition(AuxC.getXPosition());
        ficha.setYPosition(AuxC.getYPosition());
        fichas.get(row-1).set(column-1,ficha);
        makeVisible();
    }
    
    /**
     * param int[][] pieces el numero de las casillas de la ficha que eliminare.
     */
    public void removeFichas(int[][] pieces){
        Casilla auxiliar;
        for(int i=0;i<pieces.length;i++){
            removeFicha((pieces[i][0])-1,(pieces[i][1])-1);
        }
    }
    /**
     * @param int row fila donde se va a remover la ficha
     * @param int column columna donde se removera la ficha
     */
    public void removeFicha(int row, int column){
        Casilla auxiliar;
        auxiliar = juego.get((row)-1).get((column)-1);
        Fichas ficha = hayUnaFicha(row-1,column-1);
        if(ficha!=null){
            ficha.makeInvisible();
            fichas.remove(ficha);
        }
        else{
            JOptionPane.showMessageDialog(null,"No hay fichas en la posicion seleccionada, intenta de nuevo.");
        }
        
        
    }
    
    
     public void select(int row, int column){
        Casilla AuxC = juego.get(row-1).get(column-1);
        Fichas ficha=hayUnaFicha(row, column);
        if (ficha!=null){
            fichas.get(row-1).get(column-1).changeColor("cyan");
            isMoveable(row-1,column-1,juego.size());
        }
        else{
            JOptionPane.showMessageDialog(null,"No hay fichas en esta posicion,por favor intenta de nuevo");
        }
    }
    
    
    private void  isMoveable(int i, int j, int lenTablero){
        System.out.println("i: "+i);
        System.out.println("j: "+j);
        System.out.println("Len: "+lenTablero);
        if(i<lenTablero-1){
            if(j<lenTablero-1){
               if(i>1){
                   if(j>1){ //aqui abajo todos son zonaJuego
                       juego.get(i+1).get(j-1).changeColor("blue");
                       juego.get(i+1).get(j+1).changeColor("blue");
                       juego.get(i-1).get(j-1).changeColor("blue");
                       juego.get(i-1).get(j+1).changeColor("blue");
                   }
                   else{
                       juego.get(i+1).get(j+1).changeColor("blue");
                       juego.get(i-1).get(j+1).changeColor("blue");
                   }
               }
               else{
                   if(j>1){
                       juego.get(i+1).get(j-1).changeColor("blue");
                       juego.get(i+1).get(j+1).changeColor("blue");
                   }
                   else{
                       juego.get(i+1).get(j+1).changeColor("blue");
                   }
               }
            }
            
        }
    }
    
    public Fichas hayUnaFicha(int row, int column){
        Casilla auxiliar;
        auxiliar = juego.get((row-1)).get((column-1));
        for(int j=0;j<fichas.size();j++){
            for(int k=0;k<fichas.get(j).size();k++){
                if(fichas.get(j).get(k)!=null){
                      if(fichas.get(j).get(k).getXPosition()==auxiliar.getXPosition()-1){
                        if(fichas.get(j).get(k).getYPosition()==auxiliar.getYPosition()-1){
                            return fichas.get(j).get(k);
                        }
                    }
                }
            }  
        }
        return null;
    }
    
    public void madeASwap(){
        for(ArrayList<Fichas> ficha:fichas){
            for(Fichas f: ficha){
                if(f!=null){
                    f.makeInvisible();
                }
            }
        }
    }
    
    public ArrayList<ArrayList<Fichas>> getFichas(){
        return fichas;
    
    }
    
    public ArrayList<ArrayList<Casilla>> getCasillas(){
        return juego;
    }
 }