public class InvalidPromoException extends RuntimeException {
    public InvalidPromoException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "InvalidPromoException{"+getMessage()+"}";
    }
}
