package day7;

import day7.operation.*;

import java.util.*;

/**
 * Created by marcin on 21.12.15.
 */
public class OperationsManager {
    private List<Operation> operations;
    private Map<String, Long> values;
    private List<String> lines;
    private List<String> notParsed;

    public OperationsManager() {
        operations = new ArrayList<Operation>();
        values = new HashMap<String, Long>();
        lines = new ArrayList<String>();
        notParsed = new ArrayList<String>();
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

    public void parse(String line) {
        if (line.startsWith("//")){
            return;
        }
        String original = line;
        lines.add(line);
        if (line.contains("AND")){
            line = line.replace("AND ", "").replace("-> ", "");
            String[] splitted = line.split(" ");
            Input i1 = null;
            if (isNumeric(splitted[0]) == null) {
                i1 = new Input(splitted[0], null);
            } else {
                i1 = new Input((new Date()).hashCode()+"a", isNumeric(splitted[0]));
            }
            Input i2 = null;
            if (isNumeric(splitted[1]) == null) {
                i2 = new Input(splitted[1], null);
            } else {
                i2 = new Input((new Date()).hashCode()+"b", isNumeric(splitted[1]));
            }
            List<Input> inputs = new ArrayList<Input>();
            inputs.add(i1);
            inputs.add(i2);
            Output output = new Output(splitted[2], null);
            And and = new And(inputs, output);
            add(and);
        } else
        if (line.contains("OR")){
            line = line.replace("OR ", "").replace("-> ", "");
            String[] splitted = line.split(" ");
            Input i1 = null;
            if (isNumeric(splitted[0]) == null) {
                i1 = new Input(splitted[0], null);
            } else {
                i1 = new Input((new Date()).hashCode()+"c", isNumeric(splitted[0]));
            }
            Input i2 = null;
            if (isNumeric(splitted[1]) == null) {
                i2 = new Input(splitted[1], null);
            } else {
                i2 = new Input((new Date()).hashCode()+"d", isNumeric(splitted[1]));
            }
            List<Input> inputs = new ArrayList<Input>();
            inputs.add(i1);
            inputs.add(i2);
            Output output = new Output(splitted[2], null);
            Or or = new Or(inputs, output);
            add(or);
        } else
        if (line.contains("LSHIFT")){
            line = line.replace("LSHIFT ", "").replace("-> ", "");
            String[] splitted = line.split(" ");
            Input i1 = null;
            if (isNumeric(splitted[0]) == null) {
                i1 = new Input(splitted[0], null);
            } else {
                i1 = new Input((new Date()).hashCode()+"e", isNumeric(splitted[0]));
            }
            Input i2 = null;
            if (isNumeric(splitted[1]) == null) {
                i2 = new Input(splitted[1], null);
            } else {
                i2 = new Input((new Date()).hashCode()+"f", isNumeric(splitted[1]));
            }
            List<Input> inputs = new ArrayList<Input>();
            inputs.add(i1);
            inputs.add(i2);
            Output output = new Output(splitted[2], null);
            LShift lShift = new LShift(inputs, output);
            add(lShift);
        } else
        if (line.contains("RSHIFT")){
            line = line.replace("RSHIFT ", "").replace("-> ", "");
            String[] splitted = line.split(" ");
            Input i1 = null;
            if (isNumeric(splitted[0]) == null) {
                i1 = new Input(splitted[0], null);
            } else {
                i1 = new Input((new Date()).hashCode()+"g", isNumeric(splitted[0]));
            }
            Input i2 = null;
            if (isNumeric(splitted[1]) == null) {
                i2 = new Input(splitted[1], null);
            } else {
                i2 = new Input((new Date()).hashCode()+"h", isNumeric(splitted[1]));
            }
            List<Input> inputs = new ArrayList<Input>();
            inputs.add(i1);
            inputs.add(i2);
            Output output = new Output(splitted[2], null);
            RShift rShift = new RShift(inputs, output);
            add(rShift);
        } else
        if (line.contains("NOT")){
            line = line.replace("NOT ", "").replace("-> ", "");
            String[] splitted = line.split(" ");
            Input i1 = null;
            if (isNumeric(splitted[0]) == null) {
                i1 = new Input(splitted[0], null);
            } else {
                i1 = new Input((new Date()).hashCode()+"i", isNumeric(splitted[0]));
            }
            List<Input> inputs = new ArrayList<Input>();
            inputs.add(i1);
            Output output = new Output(splitted[1], null);
            Not not = new Not(inputs, output);
            add(not);
        } else {
            line = line.replace("-> ", "");
            String[] splitted = line.split(" ");
            Input input = null;
            try {
                input = new Input(splitted[1], Long.parseLong(splitted[0]));
            } catch (Exception e){
                Long i = values.get(splitted[0]);
                input = new Input(splitted[1], i);
                if (i == null){
                    values.put(splitted[0], null);
                    values.put(splitted[1], null);
                    input = null;
                    if (!notParsed.contains(original))
                        notParsed.add(original);
                }
            }
            if (input != null)
                add(input);
        }
    }

    public void solve(){
        while ( emptyValues() ){
            List<Operation> toRemove = new ArrayList<Operation>();
            for (Operation operation : operations){
                Output output = operation.solve(values);
                if (output != null) {
                    values.put(output.getName(), output.getValue());
                    toRemove.add(operation);
                }
            }
            if (toRemove.size() == 0) {
                for(String s : notParsed){
                    parse(s);
                }
            }
            operations.removeAll(toRemove);
            System.out.println(howManyNulls());
        }
        printValues();
        System.out.println(values.get("a"));
    }

    private void printValues(){
        for (Map.Entry entry : values.entrySet())
            System.out.println(entry.getKey() + ":" + entry.getValue());
    }

    private boolean emptyValues() {
        for(Long value : values.values()){
            if (value == null)
                return true;
        }
        return false;
    }

    private int howManyNulls() {
        int nulls = 0;
        for(Long value : values.values()){
            if (value == null)
                nulls++;
        }
        return nulls;
    }

    private Long isNumeric(String s){
        Long num = null;
        try {
            num = Long.parseLong(s);
        } catch (Exception e){
            return null;
        }finally {
            return num;
        }
    }
}
