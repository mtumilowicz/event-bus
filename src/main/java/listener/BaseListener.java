package listener;

import com.google.common.eventbus.Subscribe;
import event.ForAllListenersEvent;

/**
 * Created by mtumilowicz on 2018-05-22.
 */
public class BaseListener {
    protected String message;

    @Subscribe
    private void general(ForAllListenersEvent event) {
        message = event.getMessage();
    }

    public String getMessage() {
        return message;
    }
}
