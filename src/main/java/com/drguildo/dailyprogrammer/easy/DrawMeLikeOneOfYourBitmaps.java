/*
 * Copyright (c) 2016, Simon Morgan
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.drguildo.dailyprogrammer.easy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/* Let's build a basic paint program! Your task for today will be to create a basic paint program
 * that can draw points, lines, and filled rectangles, then output an image file that many image
 * viewers can read.
 *
 * URL: https://redd.it/3zfajl
 */
public class DrawMeLikeOneOfYourBitmaps {
  static class RGB {
    private int r, g, b;

    public RGB() {
      r = g = b = 0;
    }

    public RGB(int r, int g, int b) {
      this.r = r;
      this.g = g;
      this.b = b;
    }

    @Override public String toString() {
      return String.format("%d %d %d", r, g, b);
    }
  }

  public static void writePPM(String filename, RGB[][] img) {
    try {
      PrintWriter pw = new PrintWriter(filename);
      pw.print("P3 ");
      pw.print(String.format("%d %d ", img.length, img[0].length));
      pw.print("255 ");
      for (int i = 0; i < img[0].length; i++)
        for (int j = 0; j < img.length; j++)
          pw.print(img[j][i] + " ");
      pw.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws IOException {
    if (args.length < 2)
      System.exit(-1);

    Scanner scanner = new Scanner(new File(args[0]));
    int width = scanner.nextInt();
    int height = scanner.nextInt();
    scanner.nextLine();
    System.out.println(String.format("x: %d, y: %d", width, height));

    RGB[][] img = new RGB[width][height];
    for (int i = 0; i < img.length; i++)
      for (int j = 0; j < img[i].length; j++)
        img[i][j] = new RGB();

    while (scanner.hasNextLine()) {
      String[] line = scanner.nextLine().split(" ");
      System.out.println(Arrays.toString(line));

      RGB color =
          new RGB(Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]));

      int x = Integer.parseInt(line[5]);
      int y = Integer.parseInt(line[4]);

      if (line[0].equals("point")) {
        img[x][y] = color;
        continue;
      }

      if (line[0].equals("line")) {
        int x1 = Integer.parseInt(line[7]);
        int y1 = Integer.parseInt(line[6]);
        plotLine(img, color, x, y, x1, y1);
        continue;
      }

      if (line[0].equals("rect")) {
        int lineWidth = Integer.parseInt(line[7]);
        int lineHeight = Integer.parseInt(line[6]);
        for (int i = x; i < x + lineWidth; i++)
          for (int j = y; j < y + lineHeight; j++)
            img[i][j] = color;
      }
    }

    writePPM(args[1], img);
  }

  static void plotLine(RGB[][] img, RGB color, int x0, int y0, int x1, int y1) {
    int dx = Math.abs(x1 - x0), sx = x0 < x1 ? 1 : -1;
    int dy = -Math.abs(y1 - y0), sy = y0 < y1 ? 1 : -1;
    int err = dx + dy, e2; /* error value e_xy */

    while (true) {
      img[x0][y0] = color;
      if (x0 == x1 && y0 == y1)
        break;
      e2 = 2 * err;
      if (e2 >= dy) {
        err += dy;
        x0 += sx;
      } /* e_xy+e_x > 0 */
      if (e2 <= dx) {
        err += dx;
        y0 += sy;
      } /* e_xy+e_y < 0 */
    }
  }
}
