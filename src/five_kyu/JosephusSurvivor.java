package five_kyu;

import java.util.ArrayList;
import java.util.List;

public class JosephusSurvivor {
  public static void main(String[] args) {
    //    System.out.println("josephusSurvivor(7, 3) = " + josephusSurvivor(7, 3));
    System.out.println("josephusSurvivor(14, 2) = " + josephusSurvivor(14, 2));
  }

  /**
   * In this kata you have to correctly return who is the "survivor", ie: the last element of a Josephus permutation.
   * <p>
   * Basically you have to assume that n people are put into a circle and that they are eliminated in steps of k elements, like this:
   * <p>
   * josephus_survivor(7,3) => means 7 people in a circle;
   * one every 3 is eliminated until one remains
   * [1,2,3,4,5,6,7] - initial sequence
   * [1,2,4,5,6,7] => 3 is counted out
   * [1,2,4,5,7] => 6 is counted out
   * [1,4,5,7] => 2 is counted out
   * [1,4,5] => 7 is counted out
   * [1,4] => 5 is counted out
   * [4] => 1 counted out, 4 is the last element - the survivor!
   */
  public static int josephusSurvivor(final int n, final int k) {
    List<Integer> permulation = new ArrayList<>();
    List<Integer> data = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
      data.add(i);
    }
    int position = 0;
    while (data.size() > 0) {
      position = (position + k - 1) % data.size();
      permulation.add(data.remove((int) position));
    }

    return permulation.get(n - 1);
  }
}
