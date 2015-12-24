import day8.Parser;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by marcin on 22.12.15.
 */
public class Day8Test {

    @Test
    public void test1() {
        Assert.assertEquals("", Parser.parse("\"\""));
    }

    @Test
    public void test2() {
        Assert.assertEquals("aa", Parser.parse("\"aa\""));
    }

    @Test
    public void test3() {
        Assert.assertEquals("aaa_aaa", Parser.parse("\"aaa\\\"aaa\""));
    }

    @Test
    public void test4() {
        Assert.assertEquals("aaa_aaa", Parser.parse("\"aaa\\x27aaa\""));
    }

    @Test
    public void test5() {
        Assert.assertEquals("aaa_xaaa", Parser.parse("\"aaa\\\\xaaa\""));
    }

    @Test
    public void test6() {
        Assert.assertEquals("aaa_x43aaa", Parser.parse("\"aaa\\\\x43aaa\""));
    }

    @Test
    public void test7() {
        Assert.assertEquals("_", Parser.parse("\"\\\\\""));
    }

    @Test
    public void test8() {
        Assert.assertEquals("_", Parser.parse("\"\\\'\""));
    }

    @Test
    public void test9() {
        Assert.assertEquals("_", Parser.parse("\"\\\"\""));
    }
}
