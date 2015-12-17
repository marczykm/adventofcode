import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by marcin on 17.12.15.
 */
public class Day4 {
    public static void main(String[] args) throws Exception {
        String s = "yzbqklnj";
//        s = "pqrstuv";

        int i = 0;
        String end = "";
        do {
            end = MungPass(s+i);
            i++;
        } while (!end.startsWith("000000"));

        System.out.println(--i);

    }

    public static String MungPass(String pass) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        byte[] data = pass.getBytes();
        m.update(data,0,data.length);
        BigInteger i = new BigInteger(1,m.digest());
        return String.format("%1$032X", i);
    }
}
