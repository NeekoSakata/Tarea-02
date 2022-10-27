import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    }

}
//Comprador
class Comprador{
    private String queBebiste;
    private int cuantoVuelto;
    public Comprador(Moneda m ,int seleccion , Expendedor maquina){
        this.cuantoVuelto=0;
        maquina.comprarBebida(m, seleccion);
        queBebiste =  (maquina.comprarBebida(m, seleccion)).beber();
        while(maquina.getCuentaDeVuelto()!=0){
            cuantoVuelto = cuantoVuelto + (maquina.getVuelto()).getValor();
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
    public Bebida comprarBebida(Moneda m ,int seleccion){
        if (m.getValor() == precios) {
            switch (seleccion){
                case 1: return coca.getBebida();
                case 2: return sprite.getBebida();
                case 3: return fanta.getBebida();
            }
        }
        if(m.getValor() > precios){
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
}
//"Almacen"