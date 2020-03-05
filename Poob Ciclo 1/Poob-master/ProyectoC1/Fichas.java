 import java.util.ArrayList;
/**
 * Write a description of class Fichas here.
 * 
 * @author (Felipe Marin) 
 * @version (1.0)
 */
public class Fichas
{
    private int x;
    private Circle ficha;
    private String tipo;
    /**
     * Constructor for objects of class Fichas
     */
    public Fichas()
    {
        ficha = new Circle();
        tipo = "men";
    }
    public void makeVisible(){
        ficha.makeVisible();
    }
    public void makeInvisible(){
        ficha.makeInvisible();
    }
    public int getDiameter(){
        return ficha.getDiameter();
    }
    public void setDiameter(int newDiameter){
        ficha.changeSize(newDiameter);
    }
    public int getXPosition(){
        return ficha.getXPosition();
    }
    public void setXPosition(int newXPosition){
        ficha.setXPosition(newXPosition-1);
    }
    
    public int getYPosition(){
        return ficha.getYPosition();
    }
    public void setYPosition(int newYPosition){
        ficha.setYPosition(newYPosition-1);
    }
    public String getColor(){
        return ficha.getColor();
    }
    public void changeColor(String newColor){
        ficha.changeColor(newColor);
    }
    public String getTipo(){
        return tipo; 
    }
    public void setTipo(String newSetTipo){
        tipo=newSetTipo; 
    }
}
