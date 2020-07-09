package five_kyu;

import java.util.HashMap;
import java.util.Map;

public class SimpleAssembler {
  public static void main(String[] args) {
    String[] program = new String[] { "mov a 5", "inc a", "dec a", "dec a", "jnz a -1", "inc a" };
    System.out.println(" SimpleAssembler.interpret(program); = " + SimpleAssembler.interpret(program));
  }

  /**
   * This is the first part of this kata series. Second part is here.
   * <p>
   * We want to create a simple interpreter of assembler which will support the following instructions:
   * <p>
   * mov x y - copies y (either a constant value or the content of a register) into register x
   * inc x - increases the content of the register x by one
   * dec x - decreases the content of the register x by one
   * jnz x y - jumps to an instruction y steps away (positive means forward, negative means backward, y can be a register or a constant), but only if x (a constant or a register) is not zero
   * Register names are alphabetical (letters only). Constants are always integers (positive or negative).
   * <p>
   * Note: the jnz instruction moves relative to itself. For example, an offset of -1 would continue at the previous instruction, while an offset of 2 would skip over the next instruction.
   * <p>
   * The function will take an input list with the sequence of the program instructions and will execute them. The program ends when there are no more instructions to execute, then it returns a dictionary with the contents of the registers.
   * <p>
   * Also, every inc/dec/jnz on a register will always be preceeded by a mov on the register first, so you don't need to worry about uninitialized registers.
   *
   * @param program
   * @return
   */
  public static Map<String, Integer> interpret(String[] program) {
    Map<String, Integer> result = new HashMap<>();

    for (int index = 0; index < program.length; index++) {
      String[] commandParams = program[index].split(" ");
      String commandName = commandParams[0];
      String register = commandParams[1];
      String commandValue = "";
      if (commandParams.length > 2) {
        commandValue = commandParams[2];
      }
      switch (commandName) {
      case "mov":
        mov(result, register, commandValue);
        break;
      case "inc":
        inc(result, register);
        break;
      case "dec":
        dec(result, register);
        break;
      default:
        index = jnz(result, register, index, commandValue);
        break;
      }
    }
    return result;
  }

  private static void mov(Map<String, Integer> result, String register, String copyValue) {
    result.put(register, tryParseInt(result, copyValue));
  }

  private static void inc(Map<String, Integer> result, String register) {
    result.put(register, result.get(register) + 1);
  }

  private static void dec(Map<String, Integer> result, String register) {
    result.put(register, result.get(register) - 1);
  }

  private static int jnz(Map<String, Integer> result, String register, int currentIndex, String offset) {
    if (tryParseInt(result, register) != 0) {
      return currentIndex + tryParseInt(result, offset) - 1;
    }
    return currentIndex;
  }

  public static Integer tryParseInt(Map<String, Integer> result, String numberText) {
    try {
      return Integer.parseInt(numberText);
    } catch (NumberFormatException e) {
      return result.get(numberText);
    }
  }
}
