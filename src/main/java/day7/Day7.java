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
        BufferedReader br = new BufferedReader(new FileReader("day_7.txt"));
        String line = "";

        OperationsManager om = new OperationsManager();

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
