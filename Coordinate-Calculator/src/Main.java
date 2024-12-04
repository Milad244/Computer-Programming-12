import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int xPlain = 1000;
        int yPlain = 1000;

        Scanner scan = new Scanner(System.in);
        System.out.println("Please give the X coordinate");
        int xCord = scan.nextInt();
        System.out.println("Please give the Y coordinate");
        int yCord = scan.nextInt();

        int quadrant;

        if (xCord < xPlain/2){ // Quadrant 1 or 3
            if (yCord < yPlain/2){ // Quadrant 1
                quadrant = 1;
            } else{ // Quadrant 3
                quadrant = 3;
            }
        } else{ // Quadrant 2 or 4
            if (yCord < yPlain/2){ // Quadrant 2
                quadrant = 2;
            } else{ // Quadrant 4
                quadrant = 4;
            }
        }

        System.out.println("Quadrant " + quadrant);
    }
}
