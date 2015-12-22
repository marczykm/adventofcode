package day7.operation;

import java.util.List;
import java.util.Map;

/**
 * Created by marcin on 21.12.15.
 */
public class Or extends Operation {

    public Or(List<Input> inputs, Output output) {
        super(inputs, output);
    }

    @Override
    public Output solve(Map<String, Long> values) {
        Long outputValue = null;
        for (Input i : inputs){
            Long value = values.get(i.getName());
            if (value == null)
                return null;
            if (outputValue == null)
                outputValue = value;
            else
                outputValue |= value;
        }
        output.setValue(outputValue);

        return output;
    }
}
