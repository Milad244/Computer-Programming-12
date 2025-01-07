import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<TwoDShape> twoDShapes = new ArrayList<>();

        twoDShapes.add(new Circle(5)); //Area should be approximately 78.5
        twoDShapes.add(new Triangle(5, 5, 5)); //Area should be approximately 10.8
        twoDShapes.add(new Triangle(50, 50)); //Area should be approximately 1250

        for (TwoDShape s : twoDShapes){
            System.out.println(s);
            System.out.println(s.getArea());
        }
    }
}