
public class Exception1 extends Exception {
    private String message;

    Exception1(String str) {
        message = str;
    }

    public String toString() {
        return ("Custom Exception Occurred: " + message);
    }
}