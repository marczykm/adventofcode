package day7.operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by marcin on 21.12.15.
 */
public class Input  {
    private String name;
    private Long value;

    public Input (String name, Long value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Input{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
