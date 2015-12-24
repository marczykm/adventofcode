package day8;

/**
 * Created by marcin on 22.12.15.
 */
public class Parser {
    public static String parse(String line){
        line = line.substring(1,line.length()-1);
        line = line.replaceAll("\\\\\\\\", "_");
        line = line.replaceAll("\\\\x..", "_");
        line = line.replaceAll("\\\\\'", "_");
        line = line.replaceAll("\\\\\"", "_");

        return line;
    }
}
