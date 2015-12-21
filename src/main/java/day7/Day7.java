package day7;

import day7.operation.And;
import day7.operation.Input;
import day7.operation.Output;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcin on 17.12.15.
 */
public class Day7 {
    private static final String EMPTY_STRING = "";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("day_7.txt"));
        String line = "";

        Input x = new Input("x", 123);
        Input y = new Input("y", 456);

        Input xNull = new Input("x", null);
        Input yNull = new Input("y", null);
        List<Input> inputsAnd = new ArrayList<Input>();
        inputsAnd.add(xNull);
        inputsAnd.add(yNull);
        And and = new And(inputsAnd, new Output("d", null));

        OperationsManager om = new OperationsManager();
        om.add(x);
        om.add(y);
        om.add(and);
        om.solve();


        int result = 0;

        while (line != null) {
            line = br.readLine();
            if (line == null)
                continue;
        }
        br.close();
//        System.out.println(result);
    }


}
