package listener;

import com.google.common.eventbus.Subscribe;
import event.OnlyForListenerOneEvent;

/**
 * Created by mtumilowicz on 2018-05-22.
 */
public class ListenerOne extends BaseListener {
    @Subscribe
    private void exclusive(OnlyForListenerOneEvent event) {
        message = event.getMessage();
    }
}
