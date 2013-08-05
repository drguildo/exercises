package com.drguildo.algs4.ch1.sec2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Exercise15 {
  public static int[] readInts(String fname) throws IOException {
    String line;
    StringBuffer lines = new StringBuffer();
    FileReader fr = new FileReader(fname);
    BufferedReader br = new BufferedReader(fr);

    while ((line = br.readLine()) != null) {
      lines.append(line + " ");
    }

    br.close();

    String[] s = lines.toString().split(" ");
    int[] ints = new int[s.length];
    for (int i = 0; i < s.length; i++)
      ints[i] = Integer.parseInt(s[i]);

    return ints;
  }

  public static void main(String[] args) {
    try {
      System.out.println(Arrays.toString(readInts("data/algs4/TinyT.txt")));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
