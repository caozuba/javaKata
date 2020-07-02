package five_kyu;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Going {
  public static void main(String[] args) {

  }

  /**
   * Consider the following numbers (where n! is factorial(n)):
   * <p>
   * u1 = (1 / 1!) * (1!)
   * u2 = (1 / 2!) * (1! + 2!)
   * u3 = (1 / 3!) * (1! + 2! + 3!)
   * un = (1 / n!) * (1! + 2! + 3! + ... + n!)
   * Which will win: 1 / n! or (1! + 2! + 3! + ... + n!)?
   * <p>
   * Are these numbers going to 0 because of 1/n! or to infinity due to the sum of factorials or to another number?
   * <p>
   * Task
   * Calculate (1 / n!) * (1! + 2! + 3! + ... + n!) for a given n, where n is an integer greater or equal to 1.
   * <p>
   * To avoid discussions about rounding, return the result truncated to 6 decimal places, for example:
   * <p>
   * 1.0000989217538616 will be truncated to 1.000098
   * 1.2125000000000001 will be truncated to 1.2125
   * Remark
   * Keep in mind that factorials grow rather rapidly, and you need to handle large inputs.
   *
   * @param n
   * @return
   */
  public static double going(int n) {
    double result = 1.0;
    for (int i = 0; i < n - 1; i++) {
      result += denominator(n, i);
    }

    return truncate6(result);
  }

  public static double truncate6(double input) {
    DecimalFormat df = new DecimalFormat("#.######");
    df.setRoundingMode(RoundingMode.FLOOR);
    return new Double(df.format(input));
  }

  public static double denominator(int n, int times) {
    double result = (double) 1 / n;
    for (int i = 1; i <= times; i++) {
      result /= (n - i);
    }
    return result;
  }
}
