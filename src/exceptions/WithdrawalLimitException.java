package exceptions;

public class WithdrawalLimitException extends Exception {
    public WithdrawalLimitException(String msg) {
        super(msg);
    }
}
