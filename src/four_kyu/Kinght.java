package four_kyu;

import java.util.*;

/**
 * Given two different positions on a chess board, find the least number of moves it would take a knight to get from one to the other. The positions will be passed as two arguments in algebraic notation. For example, knight("a3", "b5") should return 1.
 * <p>
 * The knight is not allowed to move off the board. The board is 8x8.
 * <p>
 * For information on knight moves, see https://en.wikipedia.org/wiki/Knight_%28chess%29
 * <p>
 * For information on algebraic notation, see https://en.wikipedia.org/wiki/Algebraic_notation_%28chess%29
 * <p>
 * (Warning: many of the tests were generated randomly. If any do not work, the test cases will return the input, output, and expected output; please post them.)
 */
public class Kinght {
  public static void main(String[] args) {

  }

  public static int knight(String start, String finish) {
    int N = 8;
    Node src = convertAlgebraicNotationToInt(start);
    Node dest = convertAlgebraicNotationToInt(finish);
    return BFS(src, dest, N);
  }

  public static class Node {
    int x, y, dist;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public Node(int x, int y, int dist) {
      this.x = x;
      this.y = y;
      this.dist = dist;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (o == null || getClass() != o.getClass())
        return false;
      Node node = (Node) o;
      return x == node.x && y == node.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }

  public static int BFS(Node src, Node dest, int N) {
    int[] row = { 2, 2, -2, -2, 1, 1, -1, -1 };
    int[] col = { -1, 1, 1, -1, 2, -2, 2, -2 };
    final int possibleMoveNo = 8;
    Set<Node> visited = new HashSet<>();

    Queue<Node> q = new ArrayDeque<>();
    q.add(src);
    while (!q.isEmpty()) {
      Node node = q.poll();

      if (node.equals(dest)) {
        return node.dist;
      }

      if (!visited.contains(node)) {
        visited.add(node);
        for (int i = 0; i < possibleMoveNo; i++) {
          int x1 = node.x + row[i];
          int y1 = node.y + col[i];

          if (isValidNode(x1, y1, N)) {
            q.add(new Node(x1, y1, node.dist + 1));
          }
        }
      }
    }
    return Integer.MAX_VALUE;
  }

  public static boolean isValidNode(int x, int y, int N) {
    return x >= 0 && y >= 0 && x < N && y < N;
  }

  public static Node convertAlgebraicNotationToInt(String notation) {
    String[] alphabetAxis = new String[] { "a", "b", "c", "d", "e", "f", "g", "h" };
    String[] numberAxis = new String[] { "1", "2", "3", "4", "5", "6", "7", "8" };
    int x = 0, y = 0;
    for (int i = 0; i < 8; i++) {
      if (notation.substring(0, 1).equals(alphabetAxis[i])) {
        x = i;
      }
      if (notation.substring(1, 2).equals(numberAxis[i])) {
        y = i;
      }
    }
    return new Node(x, y);
  }
}
