package six_kyu;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BreakCamelCaseTest {
  public BreakCamelCaseTest() {
  }

  @Test
  public void camelCase() {
    Assertions.assertEquals("camel Casing", BreakCamelCase.camelCase("camelCasing"), "Incorrect");
    Assertions.assertEquals("camel Casing Test", BreakCamelCase.camelCase("camelCasingTest"), "Incorrect");
    Assertions.assertEquals("camelcasingtest", BreakCamelCase.camelCase("camelcasingtest"), "Incorrect");
  }
}
