import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by marcin on 17.12.15.
 */
public class Day5 {
    private static final String EMPTY_STRING = "";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("day_5.txt"));
        String line = "";

        int result = 0;

        while (line != null) {
            line = br.readLine();
            if (line == null)
                continue;
            if (continsTwoPairs(line) && containsPairWithLetterBetween(line))
                result++;
        }
        br.close();
        System.out.println(result);
    }

    public static boolean hasThreeVowels(String line){
        int initialSize = line.length();
        String[] vowels = {"a", "e", "i", "o", "u"};
        for (String v : vowels)
            line = line.replaceAll(v, EMPTY_STRING);
        if (initialSize - line.length() >= 3)
            return true;
        return false;
    }

    public static boolean hasDoubleLetters(String line){
        char last = 0;
        for (char s : line.toCharArray()){
            if (s == last)
                return true;
            last = s;
        }
        return false;
    }

    public static boolean hasDisallowedStrings(String line) {
        String[] disallowed = {"ab", "cd", "pq", "xy"};
        for (String d : disallowed)
            if (line.contains(d))
                return true;
        return false;
    }

    public static boolean continsTwoPairs(String line) {
        int i = 0;
        while(i < line.length() - 1){
            String temp  = line;
            String firstChar = line.charAt(i) + "";
            String secondChar = line.charAt(++i) + "";
            String pair = firstChar + secondChar;
            temp = temp.replaceAll(pair, "");
            if ( (line.length() - temp.length()) >= 4)
                return true;
        }
        return false;
    }

    public static boolean containsPairWithLetterBetween(String line) {
        int i = 0;
        if (line.length() < 3)
            return false;
        while(i < line.length()-2){
            if (i >= line.length())
                return false;
            String firstChar = line.charAt(i) + "";
            String thirdChar = line.charAt(i+2) + "";

            if ( firstChar.equals(thirdChar))
                return true;
            i++;
        }
        return false;
    }



}
