package tarea02;

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
        Comprador compra3 = new Comprador(m2,2,maqui1);    //Moneda 500 y vuelto 0 (Sprite)
        Comprador compra4 = new Comprador(m3,3,maqui1);    //Moneda de 1000 y vuelto 500 (Fanta)
        Comprador compra5 = new Comprador(m3,1,maqui1);    //(Cocacola)
        Comprador compra6 = new Comprador(m3,1,maqui1);    //(Cocacola)
        Comprador compra7 = new Comprador(m3,1,maqui2);    //NoHayBebida            (Cocacola)
        Comprador compra8 = new Comprador(m3,1,maqui2);    //NoHayBebida            (Cocacola)
       
        Comprador compra9 = new Comprador(m4,1,maqui1);    //Pago Incorrecto
        Comprador compra10 = new Comprador(m4,1,maqui1);    //Pago Incorrecto
        Comprador compra11 = new Comprador(m3,3,maqui1);   //(Moneda de 1000 y vuelto 500 (Fanta)
        
        System.out.println("Stock: " + maqui1.getStock(1));            //compra5 y compra6 compraron, por ello el Stock es de 48
        
        System.out.println(compra3.getQueBebiste());
        System.out.println("Tu vuelto es: " + compra3.getCuantoVuelto());
        
       
       
       System.out.println(compra11.getQueBebiste());
       System.out.println("Tu vuelto es: " + compra11.getCuantoVuelto());   
    }
}