package Exception;

public class ExampleException extends  Exception {
    public String message;

    public ExampleException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }


}
