package util;

import java.util.Arrays;

public class StringUtils {
  public static void main(String[] args) {
    System.out.println("\"\" = " + "");
  }

  /**
   * Complete the method/function so that it converts dash/underscore delimited
   * words into camel casing. The first word within the output should be
   * capitalized only if the original word was capitalized (known as Upper Camel
   * Case, also often referred to as Pascal case). Examples:
   * toCamelCase("the-stealth-warrior"); // returns "theStealthWarrior"
   * toCamelCase("The_Stealth_Warrior"); // returns "TheStealthWarrior"
   *
   * @param input literal string
   * @return turned to camelCase String, empty String if input is empty or null
   */
  public static String toCamelCase(String input) {
    if (input == null || input.equals("")) {
      return "";
    }
    String[] words = input.split("[-_]+");

    return Arrays.stream(words, 1, words.length)
                 .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                 .reduce(words[0], String::concat);
  }

  public static int[] testInt(int a, int b) {
    return new int[] { 1, 2 };
  }
}
