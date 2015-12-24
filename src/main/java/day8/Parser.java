package day8;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * Created by marcin on 22.12.15.
 */
public class Parser {
    public static String decode(String line){
        line = line.substring(1,line.length()-1);
        line = line.replaceAll("\\\\\\\\", "_");
        line = line.replaceAll("\\\\x..", "_");
        line = line.replaceAll("\\\\\'", "_");
        line = line.replaceAll("\\\\\"", "_");

        return line;
    }

    public static String encode(String line){
        line = line.replaceAll("\\\\", "__");
        line = line.replaceAll("\\\"", "__");
//        line = StringEscapeUtils.escapeJava(line.trim());
        return line;
    }
}
