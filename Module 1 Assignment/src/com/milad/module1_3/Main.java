package com.milad.module1_3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<TwoDShape> twoDShapes = new ArrayList<>();

        twoDShapes.add(new Circle(5));
        twoDShapes.add(new Triangle(5, 5, 5));
        twoDShapes.add(new Triangle(50, 50));

        for (TwoDShape s : twoDShapes){
            System.out.println("ToString: " + s);
            System.out.println("Area: " + s.getArea());
            // Added showcase of rotation
            if (s instanceof Triangle){
                Triangle triangle = (Triangle) s;
                System.out.println("Default 0 rotation");
                System.out.println(triangle.getRotation());
                System.out.println("Rotating 90 deg");
                triangle.rotate90();
                System.out.println(triangle.getRotation());
                System.out.println("Rotating 180 deg. Total should now be 270");
                triangle.rotate180();
                System.out.println(triangle.getRotation());
                System.out.println("Rotating 1 deg. Total should now be 271");
                triangle.rotate(1);
                System.out.println(triangle.getRotation());
            }
        }
    }
}