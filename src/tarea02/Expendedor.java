package tarea02;

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
        }else if((coca.getStock()== 0 && seleccion == 1 )|| (sprite.getStock()== 0 && seleccion == 2 ) || (fanta.getStock()== 0 && seleccion == 3 )){
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