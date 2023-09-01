package host.plas.configs;

import host.plas.ExampleModule;
import tv.quaint.storage.resources.flat.simple.SimpleConfiguration;

import java.io.File;

public class ExampleConfig extends SimpleConfiguration {
    public ExampleConfig() {
        super("config.yml", // The name of the file.
                ExampleModule.getInstance(), // The module instance.
                false); // Whether to copy the file from the jar. (Would have to be placed in the resources folder.)
    }

    @Override
    public void init() {
        getTheAnswerToLifeAndTheUniverse(); // Set the default value for the key "example-int" to 42 if it doesn't exist.
    }

    public int getTheAnswerToLifeAndTheUniverse() {
        return getOrSetDefault("example-int", 42); // Get the value for the key "example-int", or set it to 42 if it doesn't exist.
    }

    public void setTheAnswerToLifeAndTheUniverse(int value) {
        write("example-int", value); // Set the value for the key "example-int" to the given value.
    }
}
