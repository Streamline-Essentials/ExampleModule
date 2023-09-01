package host.plas.events.own;

import lombok.Getter;
import lombok.Setter;
import net.streamline.api.events.StreamlineEvent;
import net.streamline.api.events.server.LoginCompletedEvent;

public class ExampleEvent extends StreamlineEvent {
    @Getter @Setter
    private LoginCompletedEvent event;

    public ExampleEvent(LoginCompletedEvent event) {
        super();
        this.event = event;
    }
}
