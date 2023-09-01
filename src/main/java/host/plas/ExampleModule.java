package host.plas;

import host.plas.commands.ExampleCommand;
import host.plas.configs.ExampleConfig;
import host.plas.events.ExampleListener;
import host.plas.ratapi.ExampleExpansion;
import lombok.Getter;
import lombok.Setter;
import net.streamline.api.modules.ModuleUtils;
import net.streamline.api.modules.SimpleModule;
import net.streamline.thebase.lib.pf4j.PluginWrapper;

import java.util.List;

public class ExampleModule extends SimpleModule {
    @Getter @Setter
    private static ExampleModule instance; // This will be used to access the module instance from anywhere in the plugin.

    @Getter @Setter
    private static ExampleConfig exampleConfig; // This will be used to access the config instance from anywhere in the plugin.
    @Getter @Setter
    private static ExampleListener exampleListener; // This will be used to access the listener instance from anywhere in the plugin.
    @Getter @Setter
    private static ExampleExpansion exampleExpansion; // This will be used to access the expansion instance from anywhere in the plugin.

    public ExampleModule(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public void registerCommands() {
        setCommands(List.of(
                // Add commands here.
                new ExampleCommand()
        ));
    }

    @Override
    public void onEnable() {
        instance = this; // Set the instance to this module upon enabling.

        exampleConfig = new ExampleConfig(); // Initialize the config.

        exampleListener = new ExampleListener(); // Initialize the listener.
        ModuleUtils.listen(exampleListener, this); // Register the listener.

        exampleExpansion = new ExampleExpansion(); // Initialize the expansion.
    }
}
