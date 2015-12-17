import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

/**
 * Created by marcin on 17.12.15.
 */
public class Day2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("day_2.txt"));
        String line = "";
        int sumPaper = 0;
        int sumRibbon = 0;

        while (line != null) {
            line = br.readLine();
            sumPaper += getNeededPaper(line);
            sumRibbon += getNeededRibbon(line);
        }

        br.close();
        System.out.println("SP:" + sumPaper);
        System.out.println("SR:" + sumRibbon);
    }

    private static int[] getDimensions(String line){
        if (line == null) return new int[]{0,0,0};
        String[] dimensionsString = line.split("x");
        int[] dimensions = new int[3];
        dimensions[0] = Integer.parseInt(dimensionsString[0]);
        dimensions[1] = Integer.parseInt(dimensionsString[1]);
        dimensions[2] = Integer.parseInt(dimensionsString[2]);
        return dimensions;
    }

    private static int getNeededPaper(String line) {
        int[] dimensions = getDimensions(line);

        int sum = 0;
        sum += 2 * dimensions[0] * dimensions[1] + 2 * dimensions[1] * dimensions[2] + 2 * dimensions[0] * dimensions[2];

        int[] multi = new int[3];
        multi[0] = dimensions[0] * dimensions[1];
        multi[1] = dimensions[1] * dimensions[2];
        multi[2] = dimensions[0] * dimensions[2];

        Arrays.sort(multi);
        sum += multi[0];
        return sum;
    }

    private static int getNeededRibbon(String line){
        int[] d = getDimensions(line);

        Arrays.sort(d);

        int sum = d[0] + d[0] + d[1] + d[1] + d[0]*d[1]*d[2];

        return sum;
    }
}
