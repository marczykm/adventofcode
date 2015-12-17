import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by marcin on 17.12.15.
 */
public class Day1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("day_1.txt"));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        String everything = sb.toString();
        br.close();

        int uCount = 0;
        int dCount = 0;
        int position = 0;
        int firstInBasement = 0;
        for (int i = 0; i < everything.length(); i++){
            if (everything.charAt(i) == '('){
                uCount++;
                position++;
            } else if (everything.charAt(i) == ')'){
                dCount++;
                position--;
                if (firstInBasement == 0 && position == -1){
                    firstInBasement = i+1;
                }
            }
        }

        System.out.println(uCount + ":"+dCount);
        if (uCount > dCount)
            System.out.println("UP:" + (uCount - dCount));
        else
            System.out.println("DN:" + (dCount - uCount));
        System.out.println("FIB:"+firstInBasement);
    }
}
