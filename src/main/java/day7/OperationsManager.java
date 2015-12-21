package day7;

import day7.operation.And;
import day7.operation.Input;
import day7.operation.Operation;
import day7.operation.Output;

import java.util.*;

/**
 * Created by marcin on 21.12.15.
 */
public class OperationsManager {
    private List<Operation> operations;
    private Map<String, Integer> values;

    public OperationsManager() {
        operations = new ArrayList<Operation>();
        values = new HashMap<String, Integer>();
    }

    public void add(Input input){
        values.put(input.getName(), input.getValue());
    }

    public void add(Operation operation){
        operations.add(operation);
        for (Input input : operation.getInputs()){
            if (values.get(input.getName()) == null)
                values.put(input.getName(), input.getValue());
        }
        values.put(operation.getOutput().getName(), operation.getOutput().getValue());
    }

    public void solve(){
        while (emptyValues()){
            for (Operation operation : operations){
                Output output = operation.solve(values);
                values.put(output.getName(), output.getValue());
            }
        }
        printValues();
    }

    private void printValues(){
        for (Map.Entry entry : values.entrySet())
            System.out.println(entry.getKey() + ":" + entry.getValue());
    }

    private boolean emptyValues() {
        for(Integer value : values.values()){
            if (value == null)
                return true;
        }
        return false;
    }
}
