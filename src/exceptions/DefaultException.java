package exceptions;

public class DefaultException extends Throwable {

    public String message;

    public DefaultException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DefaultException{" +
                "message='" + message + '\'' +
                '}';
    }
}
