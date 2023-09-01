package host.plas.commands;

import host.plas.ExampleModule;
import net.streamline.api.command.ModuleCommand;
import net.streamline.api.interfaces.ModuleLike;
import net.streamline.api.modules.ModuleUtils;
import net.streamline.api.savables.users.StreamlineUser;

import java.util.concurrent.ConcurrentSkipListSet;

public class ExampleCommand extends ModuleCommand {
    public ExampleCommand() {
        super(ExampleModule.getInstance(),
                "example",
                "streamline.command.example.default",
                "ex", "exmpl");
    }

    @Override
    public void run(StreamlineUser streamlineUser, String[] strings) {
        streamlineUser.sendMessage(ModuleUtils.codedString("&bHello world!")); // Send a message to the user.
        streamlineUser.sendMessage(ModuleUtils.codedString(ModuleUtils.replacePlaceholders(streamlineUser, "&bPlaceholder 1: &a%example_arg1%"))); // Can also parse placeholders.
        streamlineUser.sendMessage(ModuleUtils.codedString(ModuleUtils.replacePlaceholders(streamlineUser, "&bPlaceholder 2: &a%example_arg2_anythingcangohere%"))); // Advanced placeholders.
    }

    @Override
    public ConcurrentSkipListSet<String> doTabComplete(StreamlineUser streamlineUser, String[] strings) {
        return new ConcurrentSkipListSet<>(); // Return an empty set to disable tab completion.
    }
}
