import org.junit.*;

/**
 * Created by marcin on 17.12.15.
 */
public class Day5Test {

    @Test
    public void testPairs1() {
        Assert.assertTrue(Day5.continsTwoPairs("xyxy"));
    }

    @Test
    public void testPairs2() {
        Assert.assertTrue(Day5.continsTwoPairs("aaaa"));
    }

    @Test
    public void testPairs3() {
        Assert.assertTrue(Day5.continsTwoPairs("aabcdefgaa"));
    }

    @Test
    public void testPairs4() {
        Assert.assertFalse(Day5.continsTwoPairs("aaa"));
    }

    @Test
    public void testBetween1() {
        Assert.assertTrue(Day5.containsPairWithLetterBetween("xyx"));
    }

    @Test
    public void testBetween2() {
        Assert.assertTrue(Day5.containsPairWithLetterBetween("abcdefeghi"));
    }

    @Test
    public void testBetween3() {
        Assert.assertTrue(Day5.containsPairWithLetterBetween("aaa"));
    }

    @Test
    public void testBetween4() {
        Assert.assertFalse(Day5.containsPairWithLetterBetween("aa"));
    }

    @Test
    public void testBetween5() {
        Assert.assertFalse(Day5.containsPairWithLetterBetween("asdfghjklqwertyuio"));
    }

    @Test
    public void testVowels1() {
        String s = "aei";
        boolean result = Day5.hasThreeVowels(s);
        Assert.assertTrue(result);
    }

    @Test
    public void testVowels2() {
        String s = "xazegov";
        boolean result = Day5.hasThreeVowels(s);
        Assert.assertTrue(result);
    }

    @Test
    public void testVowels3() {
        String s = "aeiouaeiouaeiou";
        boolean result = Day5.hasThreeVowels(s);
        Assert.assertTrue(result);
    }

    @Test
    public void testVowels4() {
        String s = "ae";
        boolean result = Day5.hasThreeVowels(s);
        Assert.assertFalse(result);
    }

    @Test
    public void testVowels5() {
        String s = "aex";
        boolean result = Day5.hasThreeVowels(s);
        Assert.assertFalse(result);
    }

    @Test
    public void testDoubleLetters1() {
        String s = "xx";
        boolean result = Day5.hasDoubleLetters(s);
        Assert.assertTrue(result);
    }

    @Test
    public void testDoubleLetters2() {
        String s = "abcdde";
        boolean result = Day5.hasDoubleLetters(s);
        Assert.assertTrue(result);
    }

    @Test
    public void testDoubleLetters3() {
        String s = "aabbccdd";
        boolean result = Day5.hasDoubleLetters(s);
        Assert.assertTrue(result);
    }

    @Test
    public void testDoubleLetters4() {
        String s = "a";
        boolean result = Day5.hasDoubleLetters(s);
        Assert.assertFalse(result);
    }

    @Test
    public void testDoubleLetters5() {
        String s = "axa";
        boolean result = Day5.hasDoubleLetters(s);
        Assert.assertFalse(result);
    }

    @Test
    public void testDisallowedStrings1() {
        String s = "ab";
        boolean result = Day5.hasDisallowedStrings(s);
        Assert.assertTrue(result);
    }

    @Test
    public void testDisallowedStrings2() {
        String s = "cd";
        boolean result = Day5.hasDisallowedStrings(s);
        Assert.assertTrue(result);
    }

    @Test
    public void testDisallowedStrings3() {
        String s = "pq";
        boolean result = Day5.hasDisallowedStrings(s);
        Assert.assertTrue(result);
    }

    @Test
    public void testDisallowedStrings4() {
        String s = "xy";
        boolean result = Day5.hasDisallowedStrings(s);
        Assert.assertTrue(result);
    }

    @Test
    public void testDisallowedStrings5() {
        String s = "aabb";
        boolean result = Day5.hasDisallowedStrings(s);
        Assert.assertTrue(result);
    }

    @Test
    public void testDisallowedStrings6() {
        String s = "acb";
        boolean result = Day5.hasDisallowedStrings(s);
        Assert.assertFalse(result);
    }

}
