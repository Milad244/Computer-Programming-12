package com.milad.module1_4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<TwoDShape> twoDShapes = new ArrayList<>();

        twoDShapes.add(new Circle(5, Colour.BLUE));
        twoDShapes.add(new Triangle(5, 5, 5, Colour.Red));
        twoDShapes.add(new Triangle(50, 50, Colour.GREEN));

        for (TwoDShape s : twoDShapes){
            System.out.println("ToString: " + s);
            System.out.println("Area: " + s.getArea());
        }
    }
}