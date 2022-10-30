package tarea02;

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
