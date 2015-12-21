package day7.operation;

import java.util.List;
import java.util.Map;

/**
 * Created by marcin on 21.12.15.
 */
public class RShift extends Operation {
    public RShift(List<Input> inputs, Output output) {
        super(inputs, output);
    }

    @Override
    public Output solve(Map<String, Integer> values) {
        Integer outputValue = null;
        Input i1 = inputs.get(0);
        Input i2 = inputs.get(1);
        Integer value = values.get(i1.getName());
        if (value == null)
            return null;
        outputValue = value >> i2.getValue();
        output.setValue(outputValue);

        return output;
    }
}
