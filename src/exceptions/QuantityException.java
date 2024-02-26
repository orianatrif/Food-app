package exceptions;

public class QuantityException extends Exception{
    public QuantityException() {
    }

    public QuantityException(String message){
        super(message);
    }

}
