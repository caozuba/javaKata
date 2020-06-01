package five_kyu;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class PlayWithTwoStringsTest {

  @RunWith(value = Parameterized.class)
  public static class test_playWithTwoString {

    @Parameterized.Parameter(0)
    public String a;
    @Parameterized.Parameter(1)
    public String b;
    @Parameterized.Parameter(2)
    public String expected;
    @Parameterized.Parameter(3)
    public String assertMsg;

    @Parameterized.Parameters(name = " {index}: {3} ")
    //describe: String a, String b
    // @formatter:off
    public static Collection<Object[]> data() {
      return Arrays.asList(new Object[][] {
        { "abc", "cde", "abCCde", "Should return correct result" },
        { "abcdeFgtrzw", "defgGgfhjkwqe", "abcDeFGtrzWDEFGgGFhjkWqE", "Should return correct result" },
        { "abcdeFg", "defgG", "abcDEfgDEFGg", "Should return correct result" },
        { "abab", "bababa", "ABABbababa", "Should return correct result" },
      });
    }

    // @formatter:on
    @Test
    public void test() {
      String errMsg = String.format(assertMsg + "\nShould return 「%s」 if a is 「%s」, b is 「%s」", expected, a, b);
      String actual = PlayWithTwoStrings.playWithTwoString(a, b);
      Assert.assertEquals(errMsg, expected, actual);
    }
  }
}