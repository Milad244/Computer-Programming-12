public class Circle {
    // Fields

    private double radius;

    // Methods

    // Requires: nothing
    // Modifies: this
    // Effects: Constructor with no params so default radius is set to 1
    public Circle () {
        radius = 1.0;
    }

    // Requires: radius as a double
    // Modifies: this
    // Effects: Constructor with radius param so radius is set by the param
    public Circle (double radius){
        this.radius = radius;
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns radius as a double
    public double getRadius (){
        return radius;
    }

    // Requires: radius as a double
    // Modifies: this
    // Effects: sets radius
    public void setRadius (double radius){
        this.radius = radius;
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns area as a double
    public double getArea (){
        return Math.PI * Math.pow(radius, 2);
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns circumference as a double
    public double getCircumference(){
        return 2 * Math.PI * radius;
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns the class as a string. The string has the radius of the Circle
    @Override
    public String toString() {
        return "Circle[radius = " + radius + "]";
    }
}
