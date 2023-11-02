package exercises.exercise3b;
import java.io.Serializable;

public abstract class shape implements Serializable {
    private String color;

    public shape(String color) {
        this.color = color;
    }

    public abstract double calculateArea();

    public abstract double calculatePerimeter();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}


