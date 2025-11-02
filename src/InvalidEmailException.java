public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "InvalidEmailException{"+getMessage() +"}";
    }
}
