package tarea02;

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