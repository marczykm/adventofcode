package day7.operation;

import java.util.List;
import java.util.Map;

/**
 * Created by marcin on 21.12.15.
 */
public class And extends Operation {

    public And(List<Input> inputs, Output output) {
        super(inputs, output);
    }

    @Override
    public Output solve(Map<String, Integer> values) {
        Integer outputValue = null;
        for (Input i : inputs){
            Integer value = values.get(i.getName());
            if (value == null)
                return null;
            if (outputValue == null)
                outputValue = value;
            else
                outputValue &= value;
        }
        output.setValue(outputValue);

        return output;
    }
}
