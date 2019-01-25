/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figures;

/**
 *
 * @author evgenii
 */
public class Line {
    
    private Dot begin;
    
    private Dot end;
    
    private float k;
    
    private float b;
    
    private boolean flag;
    
    public Line(Dot dot1, Dot dot2) {
        if (dot1.getX() <= dot2.getX()) {
            begin = dot1;
            end = dot2;
        } else if (dot1.getX() > dot2.getX()) {
            begin = dot2;
            end = dot1;
        }
        float x = begin.getX() - end.getX();
        float y = begin.getY() - end.getY();
        if (x != 0.0f) {
            k = y / x;
            b = begin.getY() - k * begin.getX();
            flag = false;
        } else {
            k = y * Float.POSITIVE_INFINITY;
            b = begin.getX();
            flag = true;
        }
        
    }
    
    public boolean hasIntersection(Line line) {
        if (k == line.k) {
            return false;
        }
        float x, y;
        if (!flag && !line.flag) {
            x = (b - line.b) / (line.k - k);
            if (x >= begin.getX() && x <= end.getX() &&
            x >= line.begin.getX() && x <= line.end.getX()) {
                 return true;
            }
        } else if (flag && !line.flag) {
            x = b;
            y = line.k * x + line.b;
            if (y >= begin.getY() && y <= end.getY() &&
                x >= line.begin.getX() && x <= line.end.getX()) {
                return true;
            }
        } else if (!flag && line.flag) {
            x = line.b;
            y = k * x + b;
            if (x >= begin.getX() && x <= end.getX() &&
                y >= line.begin.getY() && y <= line.end.getY()) {
                return true;
            }
        }
        return false;
    }
        
}
