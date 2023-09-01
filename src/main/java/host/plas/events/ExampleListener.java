package host.plas.events;

import host.plas.ExampleModule;
import host.plas.events.own.ExampleEvent;
import tv.quaint.events.BaseEventListener;
import tv.quaint.events.processing.BaseProcessor;
import net.streamline.api.events.server.LoginCompletedEvent;

public class ExampleListener implements BaseEventListener {
    @BaseProcessor
    public void onPlayerJoin(LoginCompletedEvent event) {
        // Fired when a player joins the server.
        ExampleEvent exampleEvent = new ExampleEvent(event); // Create a new event.
        exampleEvent.fire(); // Fire the event.
    }

    @BaseProcessor
    public void onExampleEvent(ExampleEvent event) {
        // Do something with the event.
        ExampleModule.getInstance().logInfo("Example event fired!"); // Log something to the console.
        ExampleModule.getInstance().logInfo("Player: " + event.getEvent().getResource().getLatestName()); // Log the player's name.
    }
}
