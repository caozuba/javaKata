package four_kyu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NextBiggerNumberTest {

  @Test
  public void basicTests() {
    assertEquals(21, NextBiggerNumber.nextBiggerNumber(12));
    assertEquals(531, NextBiggerNumber.nextBiggerNumber(513));
    assertEquals(2071, NextBiggerNumber.nextBiggerNumber(2017));
    assertEquals(441, NextBiggerNumber.nextBiggerNumber(414));
    assertEquals(414, NextBiggerNumber.nextBiggerNumber(144));
  }

  @Test
  public void biggerTests() {
    assertEquals(123456798, NextBiggerNumber.nextBiggerNumber(123456789));
    assertEquals(1234567908, NextBiggerNumber.nextBiggerNumber(1234567890));
    assertEquals(-1, NextBiggerNumber.nextBiggerNumber(9876543210L));
    assertEquals(-1, NextBiggerNumber.nextBiggerNumber(9999999999L));
    assertEquals(59884848483559L, NextBiggerNumber.nextBiggerNumber(59884848459853L));
  }

}