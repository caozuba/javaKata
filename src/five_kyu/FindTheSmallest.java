package five_kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTheSmallest {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(smallest(11860031527116496L)));
  }

  /**
   * You have a positive number n consisting of digits. You can do at most one operation: Choosing the index of a digit in the number, remove this digit at that index and insert it back to another or at the same place in the number in order to find the smallest number you can get.
   * <p>
   * #Task: Return an array or a tuple or a string depending on the language (see "Sample Tests") with
   * <p>
   * 1) the smallest number you got
   * 2) the index i of the digit d you took, i as small as possible
   * 3) the index j (as small as possible) where you insert this digit d to have the smallest number.
   * Example:
   * <p>
   * smallest(261235) --> [126235, 2, 0] or (126235, 2, 0) or "126235, 2, 0"
   * 126235 is the smallest number gotten by taking 1 at index 2 and putting it at index 0
   * <p>
   * smallest(209917) --> [29917, 0, 1] or ...
   * <p>
   * [29917, 1, 0] could be a solution too but index `i` in [29917, 1, 0] is greater than
   * index `i` in [29917, 0, 1].
   * 29917 is the smallest number gotten by taking 2 at index 0 and putting it at index 1 which gave 029917 which is the number 29917.
   * <p>
   * smallest(1000000) --> [1, 0, 6] or ...
   *
   * @param n
   * @return
   */
  public static long[] smallest(long n) {
    // your code
    List<Integer> digits = toArrayInt(n);
    int minDigitIndex = 0;
    int secondMinDigitIndex = 1;
    if (digits.get(0) > digits.get(1)) {
      minDigitIndex = 1;
      secondMinDigitIndex = 0;
    }
    for (int i = 1; i < digits.size(); i++) {
      if (digits.get(i) < digits.get(minDigitIndex)) {
        secondMinDigitIndex = minDigitIndex;
        minDigitIndex = i;
      } else if (digits.get(i) < digits.get(secondMinDigitIndex)) {
        secondMinDigitIndex = i;
      }
    }
    int fromIndex;
    int toIndex;
    if (minDigitIndex == 0) {
      int temp = digits.get(secondMinDigitIndex);
      digits.remove(secondMinDigitIndex);
      digits.add(1, temp);
      fromIndex = secondMinDigitIndex;
      toIndex = 1;
    } else {
      int temp = digits.get(minDigitIndex);
      digits.remove(minDigitIndex);
      digits.add(0, temp);
      fromIndex = minDigitIndex;
      toIndex = 0;
    }
    String newNumber = "";
    for (Integer digit : digits) {
      newNumber += digit;
    }

    if (fromIndex == 1) {
      fromIndex = 0;
      toIndex = 1;
    }
    return new long[] {
      Long.parseLong(newNumber), fromIndex, toIndex
    };
  }

  private static List<Integer> toArrayInt(long number) {
    String stringNumber = String.valueOf(number);
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < stringNumber.length(); i++) {
      result.add(Integer.parseInt(String.valueOf(stringNumber.charAt(i))));
    }
    return result;
  }
}
