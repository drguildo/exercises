package com.drguildo.algs4.ch1.sec3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import edu.princeton.cs.algs4.Stack;

public class Exercise9 {
  public static void main(String[] args) {
    Stack<String> ops = new Stack<String>();
    Stack<String> vals = new Stack<String>();

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
        String expr = "(";
        String v1 = vals.pop();
        String op = ops.pop();
        if (op.equals("sqrt")) {
          expr = expr + "sqrt" + vals.pop();
        } else {
          expr = expr + vals.pop() + " " + op + " " + v1;
        }
        expr = expr + ")";
        vals.push(expr);
      } else
        vals.push(s);
    }
    StdOut.print(vals.pop());
  }
}
