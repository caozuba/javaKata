package four_kyu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KinghtTest {

  @Test
  public void sampleTests() {
    assertEquals("Test for (a1, c1)", 2, Kinght.knight("a1", "c1"));
    assertEquals("Test for (a1, f1)", 3, Kinght.knight("a1", "f1"));
    assertEquals("Test for (a1, f3)", 3, Kinght.knight("a1", "f3"));
    assertEquals("Test for (a1, f4)", 4, Kinght.knight("a1", "f4"));
    assertEquals("Test for (a1, f7)", 5, Kinght.knight("a1", "f7"));
  }
}