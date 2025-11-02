public class InvalidDateException extends RuntimeException {
    public InvalidDateException(String message) {
        super(message);
    }

  @Override
  public String toString() {
    return "InvalidDateException{"+getMessage()+"}";
  }
}
