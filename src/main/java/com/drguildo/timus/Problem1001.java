package com.drguildo.timus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

/**
 * The input stream contains a set of integer numbers Ai (0 ≤ Ai ≤ 1018). The
 * numbers are separated by any number of spaces and line breaks. A size of the
 * input stream does not exceed 256 KB.
 *
 * For each number Ai from the last one till the first one you should output its
 * square root. Each square root should be printed in a separate line with at
 * least four digits after decimal point.
 *
 * @author Simon Morgan <sjm@eml.cc>
 *
 */
public class Problem1001 {
  public static void main(String[] args) {
    try {
      Reader reader;
      if (System.getProperty("ONLINE_JUDGE") == null)
        reader = new FileReader("data/timus/Problem1001.txt");
      else
        reader = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(reader);

      ArrayList<Long> a = new ArrayList<>();

      while (br.ready()) {
        String s = br.readLine().replace(" ", "");
        if (s.equals(""))
          s = "0";
        a.add(Long.parseLong(s));
      }

      for (int i = a.size() - 1; i >= 0; i--) {
        System.out.printf("%.4f%n", Math.sqrt(a.get(i)));
      }

      br.close();
    } catch (FileNotFoundException e) {
    } catch (IOException e) {
    }
  }
}
