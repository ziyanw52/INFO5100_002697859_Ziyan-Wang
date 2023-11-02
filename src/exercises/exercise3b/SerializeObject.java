package exercises.exercise3b;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;


public class SerializeObject {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0, "Red");
        Rectangle rectangle = new Rectangle(4.0, 6.0, "Blue");
        Square square = new Square(2.0, "Green");
        Triangle triangle = new Triangle(3.0, 4.0, 5.0, "White");

        try {
            FileOutputStream fileOut = new FileOutputStream("shape.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(circle);
            out.writeObject(rectangle);
            out.writeObject(square);
            out.writeObject(triangle);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in shape.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
        // Deserialize
        try (FileInputStream fileIn = new FileInputStream("shape.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Circle deserializedCircle = (Circle) in.readObject();
            Rectangle deserializedRectangle = (Rectangle) in.readObject();
            Square deserializedSquare = (Square) in.readObject();
            Triangle deserializedTriangle = (Triangle) in.readObject();

            System.out.println("Deserialized Circle: " + deserializedCircle.calculateArea());
            System.out.println("Deserialized Rectangle: " + deserializedRectangle.calculateArea());
            System.out.println("Deserialized Square: " + deserializedSquare.calculateArea());
            System.out.println("Deserialized Triangle: " + deserializedTriangle.calculateArea());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
