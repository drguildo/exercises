package com.drguildo.algs4.ch1.sec3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class InfixToPostfix {
  public static void main(String[] args) {
    Stack<String> ops = new Stack<String>();
    Stack<String> exprs = new Stack<String>();
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
        String expr = exprs.pop();
        if (op.equals("sqrt"))
          expr = "(sqrt " + expr + ")";
        else
          expr = "( " + op + " " + exprs.pop() + " " + expr + " )";
        exprs.push(expr);
      } else
        exprs.push(s);
    }
    for (String expr : exprs)
      StdOut.println(expr);
  }
}
