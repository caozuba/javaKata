package four_kyu;

import java.util.ArrayList;
import java.util.List;

public class Snail {
  public static void main(String[] args) {

  }

  /**
   * Given an n x n array, return the array elements arranged from outermost elements to the middle element, traveling clockwise.
   * <p>
   * array = [[1,2,3],
   * [4,5,6],
   * [7,8,9]]
   * snail(array) #=> [1,2,3,6,9,8,7,4,5]
   * For better understanding, please follow the numbers of the next array consecutively:
   * <p>
   * array = [[1,2,3],
   * [8,9,4],
   * [7,6,5]]
   * snail(array) #=> [1,2,3,4,5,6,7,8,9]
   * This image will illustrate things more clearly:
   * <p>
   * <p>
   * NOTE: The idea is not sort the elements from the lowest value to the highest; the idea is to traverse the 2-d array in a clockwise snailshell pattern.
   * <p>
   * NOTE 2: The 0x0 (empty matrix) is represented as en empty array inside an array [[]].
   *
   * @param array
   * @return
   */
  public static int[] snail(int[][] array) {
    List<Integer> result = new ArrayList<>();
    if (array == null || array[0].length < 1) {
      return new int[] {};
    }
    int sideLength = array.length;
    int totalElement = sideLength * sideLength;
    Pointer pointer = new Pointer(array, 0, -1);
    for (int i = 0; i < totalElement / 2 + 1; i++) {
      //      result.add(pointer.currentPositionValue());
      //      if (sideLength == 1) {
      //        break;
      //      }
      for (int rightMov = 0; rightMov < sideLength; rightMov++) {
        pointer.moveRight();
        result.add(pointer.currentPositionValue());
      }
      for (int downMove = 0; downMove < sideLength - 1; downMove++) {
        pointer.moveDown();
        result.add(pointer.currentPositionValue());
      }
      for (int leftMove = 0; leftMove < sideLength - 1; leftMove++) {
        pointer.moveLeft();
        result.add(pointer.currentPositionValue());
      }
      for (int upMove = 0; upMove < sideLength - 2; upMove++) {
        pointer.moveUp();
        result.add(pointer.currentPositionValue());
      }
      sideLength -= 2;
    }
    return result.stream().mapToInt(Integer::intValue).toArray();
  }

  public static class Pointer {
    private int[][] sourceArr;
    private int rowIndex, colIndex;

    public Pointer(int[][] sourceArr, int rowIndex, int colIndex) {
      this.sourceArr = sourceArr;
      this.rowIndex = rowIndex;
      this.colIndex = colIndex;
    }

    int currentPositionValue() {
      return this.sourceArr[this.rowIndex][this.colIndex];
    }

    public void moveRight() {
      if (this.colIndex != this.sourceArr[0].length - 1) {
        this.colIndex++;
      }
    }

    public void moveDown() {
      if (this.rowIndex != this.sourceArr.length - 1) {
        this.rowIndex++;
      }
    }

    public void moveLeft() {
      if (this.colIndex != 0) {
        this.colIndex--;
      }
    }

    public void moveUp() {
      if (this.rowIndex != 0) {
        this.rowIndex--;
      }
    }
  }

}
