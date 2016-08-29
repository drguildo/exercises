package com.drguildo.codechef;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Your program is to use the brute-force approach in order to find the Answer
 * to Life, the Universe, and Everything. More precisely... rewrite small
 * numbers from input to output. Stop processing input after reading in the
 * number 42. All numbers at input are integers of one or two digits.
 *
 * @author Simon Morgan <sjm@sjm.io>
 *
 */
public class TEST {
  public static void main(String[] args) {
    try {
      Reader reader;
      if (System.getProperty("hail.satan") != null)
        reader = new FileReader("data/codingbat/TEST.txt");
      else
        reader = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(reader);

      while (br.ready()) {
        String s = br.readLine();
        if (s.equals("42"))
          System.exit(0);
        else
          System.out.println(s);
      }

      br.close();
    } catch (FileNotFoundException e) {
    } catch (IOException e) {
    }
  }
}
