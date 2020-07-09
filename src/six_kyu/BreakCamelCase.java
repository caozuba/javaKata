package six_kyu;

public class BreakCamelCase {
  public static void main(String[] args) {
    String output = camelCase("camelCasingTest");
    System.out.println("output = " + output);
  }

  public static String camelCase(String input) {
    String[] words = input.split("(?<=[a-z])(?=[A-Z])");
    return String.join(" ", words);
  }
}