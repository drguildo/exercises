package com.drguildo.algs4.ch1.sec3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EvaluatePostfix {
  public static void main(String[] args) {
    Stack<String> ops = new Stack<String>();
    Stack<Double> vals = new Stack<Double>();
    while (!StdIn.isEmpty()) {
      String s = StdIn.readString();
      if (s.equals("("))
        ;
      else if (s.equals("+"))
        ops.push(s);
      else if (s.equals("-"))
        ops.push(s);
      else if (s.equals("*"))
        ops.push(s);
      else if (s.equals("/"))
        ops.push(s);
      else if (s.equals("sqrt"))
        ops.push(s);
      else if (s.equals(")")) {
        String op = ops.pop();
        double v = vals.pop();
        if (op.equals("+"))
          v = vals.pop() + v;
        else if (op.equals("-"))
          v = vals.pop() - v;
        else if (op.equals("*"))
          v = vals.pop() * v;
        else if (op.equals("/"))
          v = vals.pop() / v;
        else if (op.equals("sqrt"))
          v = Math.sqrt(v);
        vals.push(v);
      }
      else
        vals.push(Double.parseDouble(s));
    }
    StdOut.println(vals.pop());
  }
}
