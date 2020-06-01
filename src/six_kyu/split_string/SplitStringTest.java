package six_kyu.split_string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class SplitStringTest {

  @RunWith(value = Parameterized.class)
  public static class test_splitString {

    @Parameterized.Parameter(0)
    public String s;
    @Parameterized.Parameter(1)
    public String[] expected;
    @Parameterized.Parameter(2)
    public String assertMsg;

    @Parameterized.Parameters(name = " {index}: {2} ")
    //describe: String s
    // @formatter:off
    public static Collection<Object[]> data() {
      return Arrays.asList(new Object[][] {
        { "abcdef", new String[] { "ab", "cd", "ef" }, "should have even string" },
        { "HelloWorld", new String[] { "He", "ll", "oW", "or", "ld" }, "should have even string" },
        { "abcde", new String[] { "ab", "cd", "e_" }, "should have odd string" },
        { "LovePizza", new String[] { "Lo", "ve", "Pi", "zz", "a_" }, "should have odd string" },
        { "a", new String[] { "a_" }, "should have one element" },
        { "", new String[] {}, "should return empty array" },
      });
    }

    // @formatter:on
    @Test
    public void test() {
      String errMsg = String.format(assertMsg + "\nShould return 「%s」 if s is 「%s」", Arrays.toString(expected), s);
      String[] actual = SplitString.splitString(s);
      assertEquals(errMsg, expected, actual);
    }
  }
}