package event;

/**
 * Created by mtumilowicz on 2018-05-22.
 */
public class BaseEvent {
    private final String message;

    public BaseEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
