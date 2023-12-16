package org.example;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class RobotGrid {
    private final int m;
    private final int n;
    private int step;
    private final List<Point> forbiddenPositions = new ArrayList<>();

    public RobotGrid(int m, int n) {
        this.m = m;
        this.n = n;
        fillForbiddenPositions();
    }

    public boolean findPath(int m, int n) {
        step++;
        System.out.print("Schritt " + step + ": ");
        if (m < 0 || n < 0) {
            System.out.println("tried (" + m + ", " + n + ") -> Fallen From Board!");
            return false;
        }
        if (isForbidden(new Point(m, n))) {
            System.out.println("tried (" + m + ", " + n + ") -> Forbidden!");
            return false;
        }
        System.out.println("did (" + m + ", " + n + ")");
        return (m == 0 && n == 0) || findPath(m, n - 1) || findPath(m - 1, n);
    }

    public boolean isForbidden(Point nextPosition) {
        return forbiddenPositions.contains(nextPosition);
    }

    public void fillForbiddenPositions() {
        forbiddenPositions.addAll(List.of(
                new Point(0, 2),
                new Point(1, 2),
                new Point(2, 2),
                new Point(3, 2),
                new Point(4, 2),
                new Point(5, 2),
                new Point(1, 0),
                new Point(2, 0),
                new Point(3, 0),
                new Point(4, 0),
                new Point(5, 0)));
    }

}


