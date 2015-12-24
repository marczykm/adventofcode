import day8.Parser;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by marcin on 22.12.15.
 */
public class Day8Test {

    @Test
    public void test1() {
        Assert.assertEquals("", Parser.decode("\"\""));
    }

    @Test
    public void test2() {
        Assert.assertEquals("aa", Parser.decode("\"aa\""));
    }

    @Test
    public void test3() {
        Assert.assertEquals("aaa_aaa", Parser.decode("\"aaa\\\"aaa\""));
    }

    @Test
    public void test4() {
        Assert.assertEquals("aaa_aaa", Parser.decode("\"aaa\\x27aaa\""));
    }

    @Test
    public void test5() {
        Assert.assertEquals("aaa_xaaa", Parser.decode("\"aaa\\\\xaaa\""));
    }

    @Test
    public void test6() {
        Assert.assertEquals("aaa_x43aaa", Parser.decode("\"aaa\\\\x43aaa\""));
    }

    @Test
    public void test7() {
        Assert.assertEquals("_", Parser.decode("\"\\\\\""));
    }

    @Test
    public void test8() {
        Assert.assertEquals("_", Parser.decode("\"\\\'\""));
    }

    @Test
    public void test9() {
        Assert.assertEquals("_", Parser.decode("\"\\\"\""));
    }

    @Test
    public void test10() {
        Assert.assertEquals(6, Parser.encode("\"\"").length());
    }

    @Test
    public void test11() {
        Assert.assertEquals(9, Parser.encode("\"abc\"").length());
    }

    @Test
    public void test12() {
        Assert.assertEquals(16, Parser.encode("\"aaa\\\"aaa\"").length());
    }

    @Test
    public void test13() {
        Assert.assertEquals(11, Parser.encode("\"\\x27\"").length());
    }
}
