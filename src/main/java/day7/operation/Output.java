package day7.operation;

/**
 * Created by marcin on 21.12.15.
 */
public class Output {
    private String name;
    private Long value;

    public Output(String name, Long value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
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
