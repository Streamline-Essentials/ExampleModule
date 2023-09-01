package host.plas.ratapi;

import lombok.NonNull;
import net.streamline.api.placeholders.expansions.RATExpansion;
import net.streamline.api.placeholders.replaceables.IdentifiedReplaceable;
import net.streamline.api.placeholders.replaceables.IdentifiedUserReplaceable;
import tv.quaint.utils.MatcherUtils;

public class ExampleExpansion extends RATExpansion {
    public ExampleExpansion() {
        super(
                new RATExpansionBuilder(
                        "example", // The identifier for the expansion.
                        "_", // The character that will be used to separate the expansion identifier from the arguments.
                        "%", // The first distinguisher for the expansion. ("%" in "%example_arg1}")
                        "%" // The last distinguisher for the expansion. ("}" in "%example_arg1}")
                )
        );
    }

    @Override
    public void init() {
        new IdentifiedReplaceable(
                this, // The expansion instance.
                "arg1", // The argument (what comes after the "_" in the placeholder).
                (s) -> "Why, hello there!") // The function that will be called when the placeholder is used. (s is the string that comes after the "_" in the placeholder when calling the placeholder list.)
                .register(); // Register the replaceable.

        new IdentifiedUserReplaceable(
                this,
                MatcherUtils.makeLiteral("arg2_") + "(.*?)", // The argument (what comes after the "_" in the placeholder).
                1, // The number of groups in the regex. (1 in this case, since there is only one group in the regex.)
                (s, u) -> "Why, hello there, " + u.getName() + "!") // The function that will be called when the placeholder is used. (s is the string that comes after the "_" in the placeholder when calling the placeholder list, and u is the user that the placeholder is being called for.)
                .register(); // Register the replaceable.
    }
}
