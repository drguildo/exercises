package com.drguildo.dailyprogrammer.easy;

import java.util.Scanner;

/*
 * This first challenge is based on a game (the mathematical variety - not quite
 * as fun!) called Conway's Game of Life. This is called a cellular automaton.
 * This means it is based on a 'playing field' of sorts, made up of lots of
 * little cells or spaces. For Conway's game of life, the grid is square - but
 * other shapes like hexagonal ones could potentially exist too. Each cell can
 * have a value - in this case, on or off - and for each 'iteration' or loop of
 * the game, the value of each cell will change depending on the other cells
 * around it. This might sound confusing at first, but looks easier when you
 * break it down a bit.
 * 
 * A cell's "neighbours" are the 8 cells around it.
 * 
 * If a cell is 'off' but exactly 3 of its neighbours are on, that cell will
 * also turn on - like reproduction.
 * 
 * If a cell is 'on' but less than two of its neighbours are on, it will die out
 * - like underpopulation.
 * 
 * If a cell is 'on' but more than three of its neighbours are on, it will die
 * out - like overcrowding.
 * 
 * Your challenge is, given an initial 'state' of 'on' and 'off' cells, and a
 * number, simulate that many steps of the Game of Life.
 * 
 * URL: http://redd.it/271xyp
 */
public class GameOfLife {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] s = scanner.nextLine().split(" ");
    int n = Integer.parseInt(s[0]); // the number of simulation iterations
    int x = Integer.parseInt(s[1]); // the grid size
    int y = Integer.parseInt(s[2]);

    boolean[][] grid = new boolean[y][x];

    for (int i = 0; i < y; i++) {
      grid[i] = parseLine(scanner.nextLine());
    }

    scanner.close();

    printGrid(grid);
    System.out.println();

    while (n > 0) {
      grid = iterate(grid);

      printGrid(grid);
      System.out.println();

      n--;
    }
  }

  private static boolean[] parseLine(String s) {
    boolean[] bs = new boolean[s.length()];

    for (int i = 0; i < bs.length; i++) {
      bs[i] = (s.charAt(i) == '#');
    }

    return bs;
  }

  private static boolean[][] iterate(boolean[][] grid) {
    boolean[][] newGrid = new boolean[grid[0].length][grid.length];

    for (int y = 0; y < grid.length; y++)
      for (int x = 0; x < grid[y].length; x++) {
        if (!grid[y][x] && countNeighbours(grid, x, y) == 3) {
          // If a cell is 'off' but exactly 3 of its neighbours are on, that
          // cell will also turn on - like reproduction.
          newGrid[y][x] = true;
        } else if (grid[y][x] && countNeighbours(grid, x, y) < 2) {
          // If a cell is 'on' but less than two of its neighbours are on, it
          // will die out - like underpopulation.
          newGrid[y][x] = false;
        } else if (grid[y][x] && countNeighbours(grid, x, y) > 3) {
          // If a cell is 'on' but more than three of its neighbours are on, it
          // will die out - like overcrowding.
          newGrid[y][x] = false;
        } else {
          newGrid[y][x] = grid[y][x];
        }
      }

    return newGrid;
  }

  // returns the number of neighbours a cell has that are "on".
  private static int countNeighbours(boolean[][] grid, int x, int y) {
    int n = 0;

    for (int i = x - 1; i <= x + 1; i++) {
      for (int j = y - 1; j <= y + 1; j++) {
        if (i == x && j == y) {
          continue;
        }

        if (normalisedCellOn(grid, i, j)) {
          n++;
        }
      }
    }

    return n;
  }

  // returns whether a cell is on, adjusting the coordinates as needed.
  private static boolean normalisedCellOn(boolean[][] grid, int x, int y) {
    if (y < 0) {
      y = grid.length - Math.abs(y);
    }
    if (y >= grid.length) {
      y = (y - grid.length);
    }
    if (x < 0) {
      x = grid[y].length - Math.abs(x);
    }
    if (x >= grid[y].length) {
      x = (x - grid[y].length);
    }

    assert !(x < 0 || x > grid[y].length || y < 0 || y > grid.length);

    return grid[y][x];
  }

  private static void printGrid(boolean[][] grid) {
    for (int y = 0; y < grid.length; y++) {
      for (int x = 0; x < grid[y].length; x++) {
        if (grid[y][x]) {
          System.out.print("#");
        } else {
          System.out.print(".");
        }
      }
      System.out.println("");
    }
  }
}
