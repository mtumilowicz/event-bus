import com.google.common.eventbus.EventBus;
import event.ForAllListenersEvent;
import event.OnlyForListenerOneEvent;
import event.OnlyForListenerTwoAndThreeEvent;
import listener.ListenerOne;
import listener.ListenerThree;
import listener.ListenerTwo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by mtumilowicz on 2018-05-22.
 */
public class EventBusTest {
    
    @Test
    public void forAllListenersEvent() {
        EventBus bus = new EventBus();

        ListenerOne one = new ListenerOne();
        ListenerTwo two = new ListenerTwo();
        ListenerThree three = new ListenerThree();

        bus.register(one);
        bus.register(two);
        bus.register(three);

        ForAllListenersEvent event = new ForAllListenersEvent();
        bus.post(event);
        
        assertEquals(event.getMessage(), one.getMessage());
        assertEquals(event.getMessage(), two.getMessage());
        assertEquals(event.getMessage(), three.getMessage());
    }
    
    @Test
    public void onlyForListenerOneEvent() {
        EventBus bus = new EventBus();

        ListenerOne one = new ListenerOne();
        ListenerTwo two = new ListenerTwo();
        ListenerThree three = new ListenerThree();

        bus.register(one);
        bus.register(two);
        bus.register(three);

        OnlyForListenerOneEvent event = new OnlyForListenerOneEvent();
        bus.post(event);

        assertEquals(event.getMessage(), one.getMessage());
        assertNull(two.getMessage());
        assertNull(three.getMessage());
    }

    @Test
    public void OnlyForListenerTwoAndThreeEvent() {
        EventBus bus = new EventBus();

        ListenerOne one = new ListenerOne();
        ListenerTwo two = new ListenerTwo();
        ListenerThree three = new ListenerThree();

        bus.register(one);
        bus.register(two);
        bus.register(three);

        OnlyForListenerTwoAndThreeEvent event = new OnlyForListenerTwoAndThreeEvent();
        bus.post(event);

        assertNull(one.getMessage());
        assertEquals(event.getMessage(), two.getMessage());
        assertEquals(event.getMessage(), three.getMessage());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void unregisterNonExisting() {
        new EventBus().unregister(new ListenerOne());
    }
    
    @Test
    public void unregisterExisting() {
        EventBus bus = new EventBus();

        ListenerOne one = new ListenerOne();
        bus.register(one);

        bus.unregister(one);
        
        OnlyForListenerOneEvent event = new OnlyForListenerOneEvent();
        bus.post(event);
        
        assertNull(one.getMessage());
    }
}
