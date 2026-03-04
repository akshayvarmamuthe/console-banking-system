package exceptions;

public class InvalidUserNameException extends Exception {
    public InvalidUserNameException(String msg) {
        super(msg);
    }
}
