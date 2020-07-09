package four_kyu;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FinderTest {

  @Test
  public void sampleTests() {
    //@formatter:off
    String a = ".W.\n"+
               ".W.\n"+
               "...",

      b = ".W.\n"+
          ".W.\n"+
          "W..",

      c = "......\n"+
          "......\n"+
          "......\n"+
          "......\n"+
          "......\n"+
          "......",

      d = "......\n"+
          "......\n"+
          "......\n"+
          "......\n"+
          ".....W\n"+
          "....W.",
      e = ".....\n" +
          ".W...\n" +
          "..W..\n" +
          "...W.\n" +
          "...W.\n" ;
    //@formatter:on
    assertTrue(Finder.pathFinder(a));
    assertTrue(Finder.pathFinder(c));
    assertFalse(Finder.pathFinder(d));
    assertFalse(Finder.pathFinder(b));
    assertTrue(Finder.pathFinder(e));
  }

  //  @Test
  //  public void isLastPartHasWall() {
  //    assertTrue(Finder.isLastPartHasWall(0, "...W.."));
  //    assertFalse(Finder.isLastPartHasWall(3, "..W...."));
  //  }

  //  @Test
  //  public void canMoveNextRow() {
  //    assertTrue(Finder.canMoveNextRow(2, "..W..."));
  //  }
}