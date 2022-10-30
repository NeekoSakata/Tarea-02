package tarea02;

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