package three_kyu;

public class BattleField {

  public static void main(String[] args) {

  }

  /**
   * Write a method that takes a field for well-known board game "Battleship" as an argument and returns true if it has a valid disposition of ships, false otherwise. Argument is guaranteed to be 10*10 two-dimension array. Elements in the array are numbers, 0 if the cell is free and 1 if occupied by ship.
   * <p>
   * Battleship (also Battleships or Sea Battle) is a guessing game for two players. Each player has a 10x10 grid containing several "ships" and objective is to destroy enemy's forces by targetting individual cells on his field. The ship occupies one or more cells in the grid. Size and number of ships may differ from version to version. In this kata we will use Soviet/Russian version of the game.
   * <p>
   * <p>
   * Before the game begins, players set up the board and place the ships accordingly to the following rules:
   * There must be single battleship (size of 4 cells), 2 cruisers (size 3), 3 destroyers (size 2) and 4 submarines (size 1). Any additional ships are not allowed, as well as missing ships.
   * Each ship must be a straight line, except for submarines, which are just single cell.
   * <p>
   * The ship cannot overlap or be in contact with any other ship, neither by edge nor by corner.
   * <p>
   * This is all you need to solve this kata. If you're interested in more information about the game, visit this link.
   *
   * @param field
   * @return
   */
  public static boolean fieldValidator(int[][] field) {
    final int SIDE = 10;
    int battleship = 1;
    final int battleShipSize = 4;
    int cruiser = 2;
    final int cruiserSize = 3;
    int destroyer = 3;
    final int destroyerSize = 2;
    int submarine = 4;
    final int submarineSize = 1;
    for (int row = 0; row < SIDE; row++) {
      for (int col = 0; col < SIDE; col++) {
        if (haveContact(field, row, col)) {
          return false;
        }

        if (haveLengthInOneDimension(field, row, col, battleShipSize + 1)) {
          return false;
        }
        if (haveLengthInOneDimension(field, row, col, battleShipSize)) {
          battleship--;
        } else if (haveLengthInOneDimension(field, row, col, cruiserSize)) {
          cruiser--;
        } else if (haveLengthInOneDimension(field, row, col, destroyerSize)) {
          destroyer--;
        } else if (haveLengthHorizontal(field, row, col, submarineSize) && haveLengthVertical(field, row, col,
          submarineSize)) {
          submarine--;
        }

      }
    }

    return battleship == 0 && cruiser == 0 && destroyer == 0 && submarine == 0;
  }

  private static boolean haveLengthInOneDimension(int[][] field, int row, int col, int shipSize) {
    return haveLengthHorizontal(field, row, col, shipSize) || haveLengthVertical(field, row, col, shipSize);
  }

  private static boolean haveContact(int[][] field, int row, int col) {
    if (row == field.length - 1 || col == field[0].length - 1) {
      return false;
    }
    return field[row][col] + field[row + 1][col + 1] == 2 || field[row + 1][col] + field[row][col + 1] == 2;
  }

  private static boolean haveLengthHorizontal(int[][] field, int row, int col, int shipSize) {
    if (col > field[0].length - shipSize) {
      return false;
    }
    if (col > 0 && field[row][col - 1] == 1) {
      return false;
    }
    int sum = 0;
    for (int i = 0; i < shipSize; i++) {
      sum += field[row][col + i];
    }
    return sum == shipSize;
  }

  private static boolean haveLengthVertical(int[][] field, int row, int col, int shipSize) {
    if (row > field.length - shipSize) {
      return false;
    }
    if (row > 0 && field[row - 1][col] == 1) {
      return false;
    }

    int sum = 0;
    for (int i = 0; i < shipSize; i++) {
      sum += field[row + i][col];
    }
    return sum == shipSize;
  }

}
