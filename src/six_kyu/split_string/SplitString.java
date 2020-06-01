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
   * @param s
   * @return
   */
  public static String[] splitString(String s) {
    int length = s.length();
    String[] strings = new String[length / 2 + length % 2];

    for (int i = 0; i < length / 2; i++) {
      strings[i] = s.substring(i * 2, i * 2 + 2);
    }

    if (length % 2 == 1) {
      strings[strings.length - 1] = s.substring(length - 1, length) + "_";
    }

    return strings;
  }
}
