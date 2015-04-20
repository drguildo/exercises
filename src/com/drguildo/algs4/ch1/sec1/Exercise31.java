package com.drguildo.algs4.ch1.sec1;

import io.sjm.stdlib.Rand;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exercise31 extends JPanel {
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.drawOval(0, 0, WIDTH, HEIGHT);
    for (Point p : points)
      g.drawOval(p.x - (CIRCLE_WIDTH / 2), p.y - (CIRCLE_HEIGHT / 2),
          CIRCLE_WIDTH, CIRCLE_HEIGHT);
    for (Line2D.Double l : lines)
      g.drawLine((int) l.x1, (int) l.y1, (int) l.x2, (int) l.y2);
  }

  private static final long serialVersionUID = 5538477006040584550L;
  private static final int WIDTH = 600;
  private static final int HEIGHT = 600;
  private static final int CIRCLE_HEIGHT = 6;
  private static final int CIRCLE_WIDTH = 6;
  private static double prob;

  private static JFrame frame;

  private static ArrayList<Point> points;
  private static ArrayList<Line2D.Double> lines;

  public static void main(String[] args) {
    if (args.length < 2)
      return;

    int n = Integer.parseInt(args[0]);
    double p = Double.parseDouble(args[1]);

    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
    frame.getContentPane().addMouseListener(new MouseListener() {
      @Override
      public void mouseReleased(MouseEvent e) {
      }

      @Override
      public void mousePressed(MouseEvent e) {
      }

      @Override
      public void mouseExited(MouseEvent e) {
      }

      @Override
      public void mouseEntered(MouseEvent e) {
      }

      @Override
      public void mouseClicked(MouseEvent e) {
        lines = generateLines(points, prob);
        frame.repaint();
      }
    });

    frame.add(new Exercise31(n, p));

    frame.pack();
    frame.setVisible(true);
  }

  /**
   * Plots n equally spaced dots of size .05 on the circumference of a circle,
   * and then, with probability p for each pair of points, draws a gray line
   * connecting them.
   * 
   * @param n
   * @param p
   */
  public Exercise31(int n, double p) {
    prob = p;

    points = generatePoints(n, WIDTH / 2);
    lines = generateLines(points, prob);
    System.out.println(points);
  }

  /**
   * Generates a list of the coordinates of n equally spaced points along the
   * circumference of a circle.
   * 
   * @param n
   *          the number of equidistant points to generate
   * @param r
   *          the radius of the circle
   * @return the list of coordinates
   */
  private static ArrayList<Point> generatePoints(int n, double r) {
    double dist = (Math.PI * 2) / n; // The distance between each point.
    ArrayList<Point> points = new ArrayList<>();

    double xmid = WIDTH / 2;
    double ymid = HEIGHT / 2;

    double x, y; // The horizontal and vertical distances from the origin.
    for (double i = 0; i < (Math.PI * 2); i += dist) {
      y = ymid + Math.sin(i) * r;
      x = xmid + Math.cos(i) * r;
      points.add(new Point((int) x, (int) y));
      System.out.printf("(%f, %f)\n", x, y);
    }

    return points;
  }

  /**
   * Given a list of points and a probability, randomly connect each point with
   * a line.
   * 
   * @param ps
   *          a list of points
   * @param p
   *          the probability of connecting each point with another
   * @return a list of lines
   */
  private static ArrayList<Line2D.Double> generateLines(ArrayList<Point> ps,
      double p) {
    ArrayList<Line2D.Double> lines = new ArrayList<>();
    Rand r = new Rand();

    for (int i = 0; i < ps.size(); i++)
      for (int j = i + 1; j < ps.size(); j++) {
        if (r.nextBoolean(p))
          lines.add(new Line2D.Double(ps.get(i), ps.get(j)));
      }

    return lines;
  }
}
