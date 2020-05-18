package five_kyu;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class JosephusPermutationTest {

  @RunWith(value = Parameterized.class)
  public static class test_josephusPermutation {

    @Parameterized.Parameter()
    public String assertMsg;
    @Parameterized.Parameter(1)
    public Object[] expected;
    @Parameterized.Parameter(2)
    public Object[] items;
    @Parameterized.Parameter(3)
    public int k;

    //describe: String str
    @Parameterized.Parameters(name = " {index}: {0} ")
    // @formatter:off
    public static Collection<Object[]> data() {
      return Arrays.asList(new Object[][] {
        { "", new Object[] { 3, 6, 2, 7, 5, 1, 4 }, new Object[] { 1, 2, 3, 4, 5, 6, 7 }, 3 },
        { "", new Object[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, new Object[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 1 },
        { "", new Object[] { 2, 4, 6, 8, 10, 3, 7, 1, 9, 5 }, new Object[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 2 },
        { "", new Object[] { 2, 4, 6, 8, 10, 3, 7, 1, 9, 5 }, new Object[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 2 },
        {
          "",
          new Object[] { "e", "s", "W", "o", "C", "d", "r", "a" },
          new Object[] { "C", "o", "d", "e", "W", "a", "r", "s" }
        },
        { "", new Object[] {}, new Object[] {}, 3 }

      });
    }

    // @formatter:on
    @Test
    public void test() {
      String errMsg = String.format(assertMsg + "\nShould return 「%s」 if items is 「%s」, k is「%d」",
        Arrays.asList(expected), Arrays.asList(items), k);
      List<?> actual = JosephusPermutation.josephusPermutation(Arrays.asList(items), k);
      Assert.assertEquals(errMsg, Arrays.asList(expected), actual);
    }
  }
}