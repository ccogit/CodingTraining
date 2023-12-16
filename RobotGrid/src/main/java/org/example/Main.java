package org.example;

public class Main {
    public static void main(String[] args) {
        RobotGrid rg = new RobotGrid(6, 5);
        rg.findPath(rg.getM(), rg.getN());
    }
}