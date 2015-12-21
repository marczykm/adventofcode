package day7.operation;

/**
 * Created by marcin on 21.12.15.
 */
public class Output {
    private String name;
    private Integer value;

    public Output(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Output{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
