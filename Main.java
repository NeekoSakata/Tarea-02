package main;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //a
    }
    
}
class Comprador{
    //a
}
//Bebidas-Sabores
abstract class Bebida{
    private int serie;
    public Bebida(int serie){
        this.serie=serie;
    }
    public int getSerie(){
        return serie;
    }
    public String beber(){
        return "sabor: ";
    }
}
class Sprite extends Bebida{
    public Sprite(int serie){
        super(serie);
    }
    public String beber(){
        return super.beber() + "sprite";
    }
}
class CocaCola extends Bebida{
    public CocaCola(int serie){
        super(serie);
    }
    public String beber(){
        return super.beber() + "cocacola";
    }
}
class Fanta extends Bebida{
    public Fanta(int serie){
        super(serie);
    }
    public String beber(){
        return super.beber() + "fanta";
    }
}
//Bebidas-Sabores

//Monedas
class Moneda{
    public Moneda(){
        
    }
}
class Moneda100{
    public Moneda100(){
        
    }
}
class Moneda500{
    public Moneda500(){
        
    }
}
class Moneda1000{
    public Moneda1000(){
        
    }
}
//Monedas
class Deposito{
    private ArrayList<Bebida> almacen;
     public Deposito(){
        almacen = new ArrayList<Bebida>();
    }
    public void addBebida(Bebida b1){
        almacen.add(b1);
        
    }
    public Bebida getBebida(){
        if (almacen.size()!=0) {
            Bebida b2 = almacen.remove(0);
            return b2;
        }else return null;
    }
}
class Expendedor{
    private Deposito coca;
    private Deposito sprite;
    public Expendedor(int n){
        coca = new Deposito();
        sprite = new Deposito();
        for (int i = 0; i < n; i++) {
            Bebida b1= new CocaCola(i+100);
            coca.addBebida(b1);
            
        }
         for (int k = 0; k < n; k++) {
            Bebida b1= new Sprite(k+200);
            sprite.addBebida(b1);
            
        }
    }
    public Bebida comprarBebida(Moneda m ,int n){
        switch (n){
              case 1: return coca.getBebida();
              case 2: return sprite.getBebida();
          }
        return null;  
    }
}