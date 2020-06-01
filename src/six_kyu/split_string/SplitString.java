package six_kyu.split_string;

public class SplitString {
  public static void main(String[] args) {

  }

  public static String[] splitString(String s) {
    int length = s.length();
    String[] strings = new String[length / 2 + length % 2];
    for (int i = 0; i < strings.length - 1; i++) {
      strings[i] = s.substring(i * 2, 2);
    }
    if (length % 2 == 0) {
      strings[strings.length - 1] = s.substring(s.length() - 1, 2);
    } else {
      strings[strings.length - 1] = s.substring(s.length() - 1, 1) + "_";
    }

    return strings;
  }
}
