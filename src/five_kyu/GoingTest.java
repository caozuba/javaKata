package five_kyu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoingTest {

  private static final double DELTA = 1e-10;

  @Test
  public void test1() {
    assertEquals(1.275, Going.going(5), DELTA);
  }

  @Test
  public void test2() {
    assertEquals(1.2125, Going.going(6), DELTA);
  }

  @Test
  public void test3() {
    assertEquals(1.173214, Going.going(7), DELTA);
  }

}
