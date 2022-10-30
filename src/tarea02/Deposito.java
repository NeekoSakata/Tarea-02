package tarea02;
import java.util.ArrayList;
//"Almacen"

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
    public Bebida get(int n){
        return almacen.get(n);
    }
    public int getStock(){
        return almacen.size();
    }
}
//"Almacen"
