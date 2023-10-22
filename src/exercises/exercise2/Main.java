package exercises.exercise2;

public class Main {
    public static void main(String[] args) {
        // polymorphism
        shape circle = new Circle(5.0, "Red");
        shape rectangle = new Rectangle(4.0, 6.0, "Blue");
        shape square = new Square(2.0, "Green");
        shape triangle = new Triangle(3.0, 4.0, 5.0, "White");

        // calculate area and perimeter
        System.out.println("Circle Area: " + circle.calculateArea());
        System.out.println("Circle Perimeter: " + circle.calculatePerimeter());

        System.out.println("Rectangle Area: " + rectangle.calculateArea());
        System.out.println("Rectangle Perimeter: " + rectangle.calculatePerimeter());

        System.out.println("Triangle Area: " + triangle.calculateArea());
        System.out.println("Triangle Perimeter: " + triangle.calculatePerimeter());

        System.out.println("Square Area: " + square.calculateArea());
        System.out.println("Square Perimeter: " + square.calculatePerimeter());

        System.out.println("Circle Color: " + circle.getColor());
        System.out.println("Rectangle Color: " + rectangle.getColor());
        System.out.println("Triangle Color: " + triangle.getColor());
        System.out.println("Square Color: " + square.getColor());
    }
}

