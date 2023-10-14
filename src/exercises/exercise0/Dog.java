package exercises.exercise0;

public class Dog {
    private String name;
    private int age;
    private String breed;
    private double weight;
    private String color;
    private boolean isTrained;
    private boolean isHealthy;
    private String ownerName;

    public Dog(String name, int age, String breed, double weight, String color, boolean isTrained, boolean isHealthy, String ownerName) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.weight = weight;
        this.color = color;
        this.isTrained = isTrained;
        this.isHealthy = isHealthy;
        this.ownerName = ownerName;
        System.out.println("Dog instance created. Dog name: " + name);
    }

    public void play() {
        System.out.println("Dog" + name + "is playing");
    }

    public void bark() {
        System.out.println("Dog" + name + "is barking");
    }

    public void eat() {
        System.out.println("Dog" + name + "is eating");
    }
}
