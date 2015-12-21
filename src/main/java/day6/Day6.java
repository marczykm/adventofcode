package day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by marcin on 17.12.15.
 */
public class Day6 {
    private static final String EMPTY_STRING = "";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("day_6.txt"));
        String line = "";

        int result = 0;

        while (line != null) {
            line = br.readLine();
            if (line == null)
                continue;

        }
        br.close();
        System.out.println(result);
    }






}
