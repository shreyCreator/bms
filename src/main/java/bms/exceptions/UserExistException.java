package bms.exceptions;

public class UserExistException extends RuntimeException {
    public UserExistException(String str) {
        super(str);
    }
}