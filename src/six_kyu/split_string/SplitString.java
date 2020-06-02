package six_kyu.split_string;

import java.util.Arrays;

public class SplitString {
  public static void main(String[] args) {
    System.out.println("splitString(\"HellWorld\") = " + Arrays.toString(splitString("HellWorld")));
  }

  /**
   * Complete the solution so that it splits the string into pairs
   * of two characters. If the string contains an odd number of
   * characters then it should replace the missing second character of the
   * final pair with an underscore ('_').
   * <p>
   * Examples:
   * <p>
   * StringSplit.solution("abc") // should return {"ab", "c_"}
   * StringSplit.solution("abcdef") // should return {"ab", "cd", "ef"}
   *
   * @param s input string
   * @return an array of spliced string
   */
  public static String[] splitString(String s) {
    s = s.length() % 2 == 0 ? s : s + "_";
    return s.split("(?<=\\G.{2})");
  }

}
