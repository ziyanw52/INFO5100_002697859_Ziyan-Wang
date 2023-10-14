package exercises.exercise0;

public class Cat {
    private String name;
    private int age;
    private String breed;
    private double weight;
    private String color;
    private String eyeColor;
    private boolean isHealthy;
    private String ownerName;

    public Cat(String name, int age, String breed, double weight, String color, String eyeColor, boolean isHealthy, String ownerName) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.weight = weight;
        this.color = color;
        this.eyeColor = eyeColor;
        this.isHealthy = isHealthy;
        this.ownerName = ownerName;
        System.out.println("Cat instance created. Cat name: " + name);
    }

    public void play() {
        System.out.println("Cat" + name + "is playing");
    }

    public void bark() {
        System.out.println("Cat" + name + "is sleeping");
    }

    public void eat() {
        System.out.println("Cat" + name + "is eating");
    }
}
