package four_kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NextBiggerNumber {
  public static void main(String[] args) {

  }

  /**
   * Create a function that takes a positive integer and returns the next bigger number that can be formed by rearranging its digits. For example:
   * <p>
   * 12 ==> 21
   * 513 ==> 531
   * 2017 ==> 2071
   * nextBigger(num: 12)   // returns 21
   * nextBigger(num: 513)  // returns 531
   * nextBigger(num: 2017) // returns 2071
   * If the digits can't be rearranged to form a bigger number, return -1 (or nil in Swift):
   * <p>
   * 9 ==> -1
   * 111 ==> -1
   * 531 ==> -1
   * nextBigger(num: 9)   // returns nil
   * nextBigger(num: 111) // returns nil
   * nextBigger(num: 531) // returns nil
   *
   * @param n
   * @return
   */
  public static long nextBiggerNumber(long n) {
    char[] s = String.valueOf(n).toCharArray();
    for (int i = s.length - 2; i >= 0; i--) {
      for (int j = s.length - 1; j > i; j--) {
        if (s[i] < s[j]) {
          char tmp = s[i];
          s[i] = s[j];
          s[j] = tmp;
          Arrays.sort(s, i + 1, s.length);
          return Long.parseLong(String.valueOf(s));
        }
      }
    }
    return -1;

  }
}
