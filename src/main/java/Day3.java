import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by marcin on 17.12.15.
 */
public class Day3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("day_3.txt"));
        String all = "";
        String line = "";

        while (line != null) {
            line = br.readLine();
            all += line;
        }
        br.close();
//        all = "^v^v^v^v^v";

        int xS = 0;
        int yS = 0;
        int xRS = 0;
        int yRS = 0;
        Set<String> uniq = new HashSet<String>();
        uniq.add(xS+":"+yS);
        uniq.add(xRS+":"+yRS);
        boolean santa = true;
        for (int i = 0; i < all.length(); i++){
            char c = all.charAt(i);

            if (santa) {
                if (c == '^')
                    yS++;
                else if (c == 'v')
                    yS--;
                else if (c == '<')
                    xS--;
                else if (c == '>')
                    xS++;
                uniq.add(xS + ":" + yS);
            }

            if (!santa){
                    if (c == '^')
                        yRS++;
                    else if (c == 'v')
                        yRS--;
                    else if (c == '<')
                        xRS--;
                    else if (c == '>')
                        xRS++;
                    uniq.add(xRS + ":" + yRS);

            }
            santa = !santa;
        }

        System.out.println(uniq.size());
    }
}
