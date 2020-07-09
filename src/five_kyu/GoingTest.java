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

  @Test
  public void test4() {
    assertEquals(1.146651, Going.going(8), DELTA);
  }

  @Test
  public void test5() {
    assertEquals(1.034525, Going.going(30), DELTA);
  }

  @Test
  public void test6() {
    assertEquals(1.052786, Going.going(20), DELTA);
  }

  @Test
  public void test7() {
    assertEquals(1.020416, Going.going(50), DELTA);
  }

  @Test
  public void test8() {
    assertEquals(1.008929, Going.going(113), DELTA);
  }

  @Test
  public void test9() {
    assertEquals(1.005025, Going.going(200), DELTA);
  }

  @Test
  public void test10() {
    assertEquals(1.001915, Going.going(523), DELTA);
  }

  @Test
  public void test11() {
    assertEquals(1.00099, Going.going(1011), DELTA);
  }

  @Test
  public void test12() {
    assertEquals(1.000098, Going.going(10110), DELTA);
  }
  
}
