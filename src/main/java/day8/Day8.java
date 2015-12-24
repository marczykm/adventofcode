package day8;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by marcin on 17.12.15.
 */
public class Day8 {
    private static final String EMPTY_STRING = "";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("day_8.txt"));
        String line = "";

        int all = 0;
        int result = 0;

        while (line != null) {
            line = br.readLine();
            if (line == null)
                continue;
            all += line.length();
            String parsed = Parser.encode(line);
            result += parsed.length()+2;
            System.out.println(line + " : " + parsed);
        }
        br.close();
        System.out.println(result + "-" + all + "= " + (result-all));
    }


}
