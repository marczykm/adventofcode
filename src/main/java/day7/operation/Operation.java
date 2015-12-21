package day7.operation;

import java.util.List;
import java.util.Map;

/**
 * Created by marcin on 21.12.15.
 */
public abstract class Operation {

    protected List<Input> inputs;
    protected Output output;

    public Operation(List<Input> inputs, Output output) {
        this.inputs = inputs;
        this.output = output;
    }

    public List<Input> getInputs() {
        return inputs;
    }

    public Output getOutput() {
        return output;
    }

    public abstract Output solve(Map<String, Integer> values);
}
