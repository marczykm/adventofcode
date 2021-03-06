package day7.operation;

import java.util.List;
import java.util.Map;

/**
 * Created by marcin on 21.12.15.
 */
public class Not extends Operation {
    public Not(List<Input> inputs, Output output) {
        super(inputs, output);
    }

    @Override
    public Output solve(Map<String, Long> values) {
        Long outputValue = null;
        Input i = inputs.get(0);
        Long value = values.get(i.getName());
        if (value == null)
            return null;
        outputValue = 65536 + ~value;

        output.setValue(outputValue);

        return output;
    }
}
