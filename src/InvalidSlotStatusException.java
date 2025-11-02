public class InvalidSlotStatusException extends RuntimeException {
    public InvalidSlotStatusException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "InvalidSlotStatusException{"+getMessage()+"}";
    }
}
