package Znakov.Practice5.Exceptions;

public class MyColumnException extends Exception {
    @Override
    public String getMessage() {
        return "Wrong column for my program. Try again";
    }
}
