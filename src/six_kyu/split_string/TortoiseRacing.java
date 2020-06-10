package six_kyu.split_string;

import java.util.Arrays;

public class TortoiseRacing {
  public static void main(String[] args) {
    int[] result = race(80, 91, 37);
    System.out.println("result = " + Arrays.toString(result));
  }

  /**
   * Two tortoises named A and B must run a race. A starts with an average speed of 720 feet per hour. Young B knows she runs faster than A, and furthermore has not finished her cabbage.
   * <p>
   * When she starts, at last, she can see that A has a 70 feet lead but B's speed is 850 feet per hour. How long will it take B to catch A?
   * <p>
   * More generally: given two speeds v1 (A's speed, integer > 0) and v2 (B's speed, integer > 0) and a lead g (integer > 0) how long will it take B to catch A?
   * <p>
   * The result will be an array [hour, min, sec] which is the time needed in hours, minutes and seconds (round down to the nearest second) or a string in some languages.
   * <p>
   * If v1 >= v2 then return nil, nothing, null, None or {-1, -1, -1} for C++, C, Go, Nim, [] for Kotlin or "-1 -1 -1".
   */

  public static int[] race(int v1, int v2, int g) {
    if (v1 >= v2) {
      return null;
    }

    float time = (float) g / (v2 - v1);
    int hour = (int) time;
    float remainHour = time - hour;

    float remainMinute = remainHour * 60;
    int minute = (int) remainMinute;

    float remainSecond = remainMinute - minute;

    int second = (int) (remainSecond * 60);
    return new int[] { hour, minute, second };
    // your code
  }

}
