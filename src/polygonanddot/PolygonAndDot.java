/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polygonanddot;

import figures.Dot;
import figures.Line;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author evgenii
 */
public class PolygonAndDot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfDot = scanner.nextInt();
        int count = 0;
        List<Line> listOfLines = new LinkedList();
        List<Dot> listOfDots = new LinkedList();
        Dot dot = new Dot(scanner.nextFloat(), scanner.nextFloat());
        listOfDots.add(dot);
        Dot dot1 = new Dot(dot.getX() * 1.1f, dot.getY() * 1.1f); 
        for (int i = 1; i < numOfDot; i++) {
            dot = new Dot(scanner.nextFloat(), scanner.nextFloat());
            listOfDots.add(dot);
            if (dot.getX() >= dot1.getX()) {
                dot1 = new Dot(dot.getX() * 1.1f, dot1.getY()); 
            }
            if (dot.getY() >= dot1.getY()) {
                dot1 = new Dot(dot1.getX(), dot.getY() * 1.1f); 
            }
        }
        Dot dot2 = new Dot(scanner.nextFloat(), scanner.nextFloat());
        Line line = new Line(dot1, dot2);
        for (Dot d : listOfDots) {
            listOfLines.add(new Line(dot, d));
            dot = d;
        }
        for (Line l : listOfLines) {
            if (line.hasIntersection(l)) {
                count++;
            }
        }
        String str = (count % 2) == 0 ? "NO" : "OK";
        System.out.println(str);
    }
    
}
