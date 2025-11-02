public class InvalidNameException extends RuntimeException {
    public InvalidNameException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "InvalidNameException{"+getMessage()+"}";
    }
}
