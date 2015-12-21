package day7;

import day7.operation.*;

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
        BufferedReader br = new BufferedReader(new FileReader("day_7_test.txt"));
        String line = "";

//        Input x = new Input("x", 123);
//        Input y = new Input("y", 456);
//
//        Input xNull = new Input("x", null);
//        Input yNull = new Input("z", 2);
//        List<Input> inputsAnd = new ArrayList<Input>();
//        inputsAnd.add(xNull);
//        inputsAnd.add(yNull);
//        And and = new And(inputsAnd, new Output("d", null));
//        Or and = new Or(inputsAnd, new Output("d", null));
//        Not and = new Not(inputsAnd, new Output("d", null));
//        LShift and = new LShift(inputsAnd, new Output("d", null));

        OperationsManager om = new OperationsManager();
//        om.add(x);
//        om.add(y);
//        om.add(and);

        while (line != null) {
            line = br.readLine();
            if (line == null)
                continue;
            om.parse(line);
        }
        br.close();
        om.solve();
    }


}
