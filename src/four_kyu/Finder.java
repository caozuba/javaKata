package four_kyu;

public class Finder {
  public static void main(String[] args) {

  }

  /**
   * ask
   * You are at position [0, 0] in maze NxN and you can only move in one of the four cardinal directions (i.e. North, East, South, West). Return true if you can reach position [N-1, N-1] or false otherwise.
   * <p>
   * Empty positions are marked .. Walls are marked W. Start and exit positions are empty in all test cases.
   *
   * @param maze
   * @return
   */
  public static boolean pathFinder(String maze) {
    String[] mazeRows = maze.split("\n");
    // Your code here!!
    int currentPositionCol = 0;
    int length = mazeRows.length;
    for (int i = 0; i < length; i++) {
      if (i == length - 1) {
        break;
      }
      String currentRow = mazeRows[i];
      String nextRow = mazeRows[i + 1];
      while (!canMoveNextRow(currentPositionCol, nextRow)) {
        currentPositionCol++;
        if (currentPositionCol == currentRow.length()) {
          return false;
        }
      }
    }
    return !isLastPartHasWall(currentPositionCol, mazeRows[length - 1]);
  }

  private static boolean canMoveRight(int currentColNum, String currentRow) {
    String rightPoint = currentRow.substring(currentColNum, currentColNum + 1);
    return !rightPoint.equals("W");
  }

  private static boolean canMoveNextRow(int currentColNum, String nextRow) {
    String nextRowPoint = nextRow.substring(currentColNum, currentColNum + 1);
    return !nextRowPoint.equals("W");
  }

  private static boolean isLastPartHasWall(int currentCol, String lastRow) {
    return lastRow.substring(currentCol).contains("W");
  }
}
