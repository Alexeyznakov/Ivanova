package Znakov.Practice5.Exceptions;

public class MyStudentException extends Exception {

    public MyStudentException(String message) {
        super(message);
    }
    public static void wrongQuantity() throws MyStudentException{
        throw new MyStudentException("Quantity has to be more than zero. Try Again");
    }
    public static void wrongCourse() throws MyStudentException{
        throw new MyStudentException("Course has to be beetwen 1 - 5. Try Again");
    }
}
