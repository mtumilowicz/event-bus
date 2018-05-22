package listener;

import com.google.common.eventbus.Subscribe;
import event.OnlyForListenerTwoAndThreeEvent;

/**
 * Created by mtumilowicz on 2018-05-22.
 */
public class ListenerTwo extends BaseListener {
    @Subscribe
    private void exclusive(OnlyForListenerTwoAndThreeEvent event) {
        message = event.getMessage();
    }
}
