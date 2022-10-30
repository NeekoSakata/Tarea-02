package tarea02;

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
