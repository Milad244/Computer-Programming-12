package com.milad.module1_4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<TwoDShape> twoDShapes = new ArrayList<>();

        twoDShapes.add(new Circle(5, Colour.BLUE)); //Area should be approximately 78.5
        twoDShapes.add(new Triangle(5, 5, 5, Colour.Red)); //Area should be approximately 10.8
        twoDShapes.add(new Triangle(50, 50, Colour.GREEN)); //Area should be approximately 1250
        Triangle t = new Triangle(-59, 50, Colour.BLUE);

        for (TwoDShape s : twoDShapes){
            System.out.println("ToString: " + s);
            System.out.println("Area: " + s.getArea());

            if (s instanceof Triangle){ // Rotates any triangle a total of 370 deg
                Triangle triangle = (Triangle) s;
                triangle.rotate90();
                triangle.rotate180();
                triangle.rotate(100);
                System.out.println("Triangle Rotation: " + triangle);
            }
        }
    }
}