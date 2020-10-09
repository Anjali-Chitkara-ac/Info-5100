package Assignment4;

public class TestCylinder {
    public static void main(String[] args) {

        //Constructed a Circle with Circle()
        Circle c = new Circle();
        //Run of the program should produce the following output:
        //Radius is 2.0, Color is yellow, Base area is (your answer)
        c.setRadius(2.0);
        c.setColor("Yellow");
        c.getArea();
        System.out.println("Radius is " + c.getRadius() + ", Color is " + c.getColor()
                            + ", Base area is "+ c.getArea());

        //Constructed a Cylinder with Cylinder()
        Cylinder b = new Cylinder();
        //Run of the program should produce the following output:
        //Radius is 1.0, Height is 1.0, Color is red, Base area is (your answer), Volume is (your answer)
        System.out.println("Radius is " + b.getRadius() + ", Height is " + b.getHeight() + ", Color is "
                             + b.getColor() + ", Base area is "+ b.getBaseArea()  + ", Volume is " + b.getVolume());

        //Constructed a Cylinder with Cylinder(height, radius)
        Cylinder a = new Cylinder(2.0,5.0);
        //Run of the program should produce the following output:
        //Radius is 2.0, Height is 5.0, Color is red, Base area is (your answer), Volume is (your answer)
        System.out.println("Radius is " + a.getRadius() + ", Height is " + a.getHeight() + ", Color is "
                + a.getColor() + ", Base area is "+ a.getBaseArea() + ", Volume is " + a.getVolume());
    }
}
