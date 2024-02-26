package exceptions;

public class NoWineException extends Exception{

    public NoWineException() {
    }
    public NoWineException(String message){
        super(message);
    }

}
