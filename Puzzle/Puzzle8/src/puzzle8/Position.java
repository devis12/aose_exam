package puzzle8;

/**
 *
 * @author gabriele
 */
public class Position {
    private int r;
    private int c;
    
    public Position(int c, int r){
        this.r = r;
        this.c = c;
    }
    
    public void setAll(int c, int r){
        this.r = r;
        this.c = c;
    }
    
    public void setR(int r){this.r = r;}
    public void setC(int c){this.c = c;}
    
    public int getR(){return r;}
    public int getC(){return c;}
}
