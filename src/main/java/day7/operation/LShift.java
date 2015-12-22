package day7.operation;

import java.util.List;
import java.util.Map;

/**
 * Created by marcin on 21.12.15.
 */
public class LShift extends Operation {
    public LShift(List<Input> inputs, Output output) {
        super(inputs, output);
    }

    @Override
    public Output solve(Map<String, Long> values) {
        Long outputValue = null;
        Input i1 = inputs.get(0);
        Input i2 = inputs.get(1);
        Long value = values.get(i1.getName());
        if (value == null)
            return null;
        outputValue = value << i2.getValue();
        if (outputValue > 65535){
            outputValue = outputValue - 65535 - 1;
        }
        output.setValue(outputValue);

        return output;
    }
}
