package tarea02;
import java.util.ArrayList;

public class Tarea02 {
    
    public static void main(String[] args) {
        Moneda100 m1 = new Moneda100();
        Moneda500 m2 = new Moneda500();
        Moneda1000 m3 = new Moneda1000();
        Moneda1000 m4 = new Moneda1000();
        m4 = null;
        //System.out.println(m1.getValor());    //Valores de las monedas
        //System.out.println(m2.getValor());
        //System.out.println(m3.getValor());
        
        Expendedor maqui1 = new Expendedor(50,500);
        Expendedor maqui2 = new Expendedor(0,500);
        
        System.out.println("Stock: " + maqui1.getStock(1));            //getStock es para ver cuanto hay de almacen de un sabor(Ejemplo: getStock(1) consulta cuanta CocaCola queda en el almacen, en este caso 50)
        
        Comprador compra1 = new Comprador(m1,1,maqui1);    //PagoInsuficiente        (Cocacola)
        Comprador compra2 = new Comprador(m1,1,maqui1);    //PagoInsuficiente        (Cocacola)
        Comprador compra3 = new Comprador(m2,2,maqui1);    //Moneda 500 y vuelto 500 (Sprite)
        Comprador compra4 = new Comprador(m3,3,maqui1);    //Moneda de 1000 y vuelto 0 (Fanta)
        Comprador compra5 = new Comprador(m3,1,maqui1);    //(Cocacola)
        Comprador compra6 = new Comprador(m3,1,maqui1);    //(Cocacola)
        
        System.out.println("Stock: " + maqui1.getStock(1));            //compra5 y compra6 compraron, por ello el Stock es de 48
        
        System.out.println(compra3.getQueBebiste());
        System.out.println("Tu vuelto es: " + compra3.getCuantoVuelto());
        
       Comprador compra7 = new Comprador(m3,1,maqui2);    //NoHayBebida            (Cocacola)
       Comprador compra8 = new Comprador(m3,1,maqui2);    //NoHayBebida            (Cocacola)
       
       Comprador compra9 = new Comprador(m4,1,maqui1);    //Pago Incorrecto
       Comprador compra10 = new Comprador(m4,1,maqui1);    //Pago Incorrecto
       Comprador compra11 = new Comprador(m3,3,maqui1);   //(Moneda de 1000 y vuelto 500 (Fanta)
       
       System.out.println(compra11.getQueBebiste());
       System.out.println("Tu vuelto es: " + compra11.getCuantoVuelto());
        
        
    }
    
}
//Comprador
class Comprador{
    private String queBebiste;
    private int cuantoVuelto;
    public Comprador(Moneda m ,int seleccion , Expendedor maquina){
        this.cuantoVuelto=0;
        try{
            Bebida mibebida = maquina.comprarBebida(m, seleccion);
            queBebiste =  mibebida.beber();
            while(maquina.getCuentaDeVuelto()!=0){
                cuantoVuelto = cuantoVuelto + (maquina.getVuelto()).getValor();
            }
            
            
        }catch(NoHayBebidaException | PagoIncorrectoException | PagoInsuficienteException e){
            System.out.println(e.getMessage());
        }
         
        
    }
    
    public String getQueBebiste(){
        return queBebiste;
    }
    public int getCuantoVuelto(){
        return cuantoVuelto;
    }
}
//Comprador

//Expendedor
class Expendedor{
    private Deposito coca;
    private Deposito sprite;
    private Deposito fanta;
    private int vuelto;
    private int precios;
    public Expendedor(int cantidad ,int precios){
        this.precios = precios;
        
        
        coca = new Deposito();
        sprite = new Deposito();
        fanta = new Deposito();
        for (int i = 0; i < cantidad; i++) {
            Bebida b1= new CocaCola(i+100);
            coca.addBebida(b1);
            
        }
        for (int k = 0; k < cantidad; k++) {
            Bebida b1= new Sprite(k+200);
            sprite.addBebida(b1);
            
        }
        for (int j = 0; j < cantidad; j++) {
            Bebida b1= new Fanta(j+300);
            fanta.addBebida(b1);
            
        }
    }
    public Bebida comprarBebida(Moneda m ,int seleccion) throws PagoIncorrectoException, PagoInsuficienteException, NoHayBebidaException {
        if (m == null) {
            throw new PagoIncorrectoException("Pago no valido");
            
        }else if (m.getValor() < precios){
            throw new PagoInsuficienteException("Pago insuficiente");
        }else if(coca.getStock()== 0 || sprite.getStock()== 0 || fanta.getStock()== 0){
            throw new NoHayBebidaException("No hay de este sabor");
            
        }
            if (m.getValor() == precios) {
                switch (seleccion){
                   case 1: return coca.getBebida();
                   case 2: return sprite.getBebida();
                   case 3: return fanta.getBebida();
                }
            }else if(m.getValor() > precios){
                vuelto = m.getValor() - precios;
                switch (seleccion){
                     case 1: return coca.getBebida();
                     case 2: return sprite.getBebida();
                     case 3: return fanta.getBebida();
                }
            }
        return null;
    }
    public Moneda getVuelto(){
        if (vuelto!=0) {
            vuelto = vuelto - 100;
            return new Moneda100();
        }else return null;
    }
    public int getCuentaDeVuelto(){
        return vuelto;
    }
    public int getStock(int seleccion){
        switch(seleccion){
            case 1: return coca.getStock();
            case 2: return sprite.getStock();
            case 3: return fanta.getStock();
        }
        return 0;
    }
}
//Expendedor















//Monedas
class Moneda{
    public Moneda(){
        
    }
    public int getValor(){
        return 0;
    }
}
class Moneda100 extends Moneda{
    public Moneda100(){
        
    }
    public int getValor(){
        return super.getValor() + 100;
    }
}
class Moneda500 extends Moneda{
    public Moneda500(){
        
    }
    public int getValor(){
        return super.getValor() + 500;
    }
}
class Moneda1000 extends Moneda{
    public Moneda1000(){
        
    }
    public int getValor(){
        return super.getValor() + 1000;
    }
}
//Monedas






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






//Excepetions
class NoHayBebidaException extends Exception{
    public NoHayBebidaException(String mensaje){
        super(mensaje);
}
    
}
class PagoInsuficienteException extends Exception{
    public PagoInsuficienteException(String mensaje){
        super(mensaje);
    }
}
class PagoIncorrectoException extends Exception{
    public PagoIncorrectoException(String mensaje){
        super(mensaje);
    }
}
//Excepetions