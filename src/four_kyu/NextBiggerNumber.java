package four_kyu;

import java.util.ArrayList;
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
    List<Integer> digits = Stream.of(String.valueOf(n).split("")).map(Integer::parseInt).collect(Collectors.toList());

    int pivotIndex = -1;
    for (int i = digits.size() - 1; i > 0; i--) {
      if (digits.get(i) > digits.get(i - 1)) {
        pivotIndex = i - 1;
        break;
      }
    }

    if (pivotIndex == -1) {
      return pivotIndex;
    }
    int pivotDigit = digits.get(pivotIndex);
    List<Integer> leftPart = new ArrayList<>(digits.subList(0, pivotIndex));
    List<Integer> rightPart = new ArrayList<>(digits.subList(pivotIndex + 1, digits.size()));

    Collections.sort(rightPart);
    int swapIndex = rightPart.size() - 1;
    for (int i = 0; i < rightPart.size(); i++) {
      if (rightPart.get(i) > pivotDigit) {
        leftPart.add(rightPart.get(i));
        swapIndex = i;
        break;
      }
    }
    rightPart.set(swapIndex, pivotDigit);
    leftPart.addAll(rightPart);

    String finalNumber = leftPart.stream().map(String::valueOf).collect(Collectors.joining(""));
    return Long.parseLong(finalNumber);

  }
}
