package exceptions;

public class RatingException extends  Exception{

    public RatingException() {
    }

    public RatingException(String message){
        super(message);
    }
}
