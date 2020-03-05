
/**
 * Write a description of class Casilla here.
 * 
 * @author (Felipe Marin) 
 * @version (a version number or a date)
 */
public class Casilla
{
    private Rectangle casilla;

    /**
     * Constructor for objects of class Casilla
     */
    public Casilla(int x, int y)
    {
        casilla = new Rectangle(x, y);
    }
    public int getXPosition()
    {
        return casilla.getXPosition();
    }
    public void setXPosition(int newXPosition){
        casilla.setXPosition(newXPosition);
    }
    
    public int getYPosition()
    {
        return casilla.getYPosition();
    }
    public void setYPosition(int newYPosition){
        casilla.setXPosition(newYPosition);
    }
    
    /**
     * @param int newXSize nuevo valor del ancho
     * @param int newYSize nuevo valor del alto
     */
    public void changeSize(int newXSize, int newYSize){
        casilla.changeSize(newXSize, newYSize);
    }
    public int getWidth(){
        return casilla.getWidth();
    }
    public int getHeight(){
        return casilla.getHeight();
    }
    
    public void changeColor(String newColor){
        casilla.changeColor(newColor);
    }
    public String getColor(){
        return casilla.getColor();
    }
    
    public void makeVisible(){
        casilla.makeVisible();
    }
    public void makeInvisible(){
        casilla.makeInvisible();
    }
}
