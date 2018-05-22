# event-bus
The main goal of this project is to explore basic features of `EventBus` 
from `guava`.

## project description
EventBus allows publish-subscribe-style communication between components 
without requiring the components to explicitly register with one another 
(and thus be aware of each other).

_Reference:_ http://www.dmydlarz.com/2017/09/26/event-bus.html
_Reference:_ https://github.com/google/guava/wiki/EventBusExplained

## project content
Three types of listeners:  
* ListenerOne  
* ListenerTwo  
* ListenerThree    

Three types of events:
* ForAllListenersEvent  
* OnlyForListenerOneEvent  
* OnlyForListenerTwoAndThreeEvent  

Tests for all interlacings (`EventBusTest`).