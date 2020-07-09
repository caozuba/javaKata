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
  static int width;
  static int height;
  static int[][] maze; // The maze
  static boolean[][] wasHere;
  //  boolean[][] correctPath = new boolean[width][height]; // The solution to the maze
  static int startX = 0, startY = 0; // Starting X and Y values of maze
  static int endX, endY;     // Ending X and Y values of maze

  public static boolean pathFinder(String mazeStr) {
    generateMaze(mazeStr); // Create Maze (1 = path, 2 = wall)
    wasHere = new boolean[width][height];
    for (int row = 0; row < maze.length; row++)
      // Sets boolean Arrays to default values
      for (int col = 0; col < maze[row].length; col++) {
        wasHere[row][col] = false;
        //        correctPath[row][col] = false;
      }
    return recursiveSolve(startX, startY);
    // Will leave you with a boolean array (correctPath)
    // with the path indicated by true values.
    // If b is false, there is no solution to the maze
  }

  private static void generateMaze(String mazeStr) {
    String[] mazeRows = mazeStr.split("\n");
    height = mazeRows.length;
    width = mazeRows[0].length();
    maze = new int[width][height];
    endX = height - 1;
    endY = width - 1;
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        if (mazeRows[row].substring(col, col + 1).equals("W")) {
          maze[row][col] = 2;
        } else {
          maze[row][col] = 1;
        }
      }
    }
  }

  public static boolean recursiveSolve(int x, int y) {
    if (x == endX && y == endY)
      return true; // If you reached the end
    if (maze[x][y] == 2 || wasHere[x][y])
      return false;
    // If you are on a wall or already were here
    wasHere[x][y] = true;
    if (x != 0) // Checks if not on left edge
      if (recursiveSolve(x - 1, y)) { // Recalls method one to the left
        //        correctPath[x][y] = true; // Sets that path value to true;
        return true;
      }
    if (x != width - 1) // Checks if not on right edge
      if (recursiveSolve(x + 1, y)) { // Recalls method one to the right
        //        correctPath[x][y] = true;
        return true;
      }
    if (y != 0)  // Checks if not on top edge
      if (recursiveSolve(x, y - 1)) { // Recalls method one up
        //        correctPath[x][y] = true;
        return true;
      }
    if (y != height - 1) // Checks if not on bottom edge
      if (recursiveSolve(x, y + 1)) { // Recalls method one down
        //        correctPath[x][y] = true;
        return true;
      }
    return false;
  }

}
