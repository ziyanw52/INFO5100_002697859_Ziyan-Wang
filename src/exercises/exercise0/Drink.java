package exercises.exercise0;

public class Drink {
    private String name;
    private String type;
    private double temperature;
    private String size;
    private int price;
    private boolean isAlcoholic;
    private boolean isCarbonated;
    private boolean isDiary;

    public Drink(String name, String type, double temperature, String size, int price, boolean isAlcoholic, boolean isCarbonated, boolean isDiary) {
        this.name = name;
        this.type = type;
        this.temperature = temperature;
        this.size = size;
        this.price = price;
        this.isAlcoholic = isAlcoholic;
        this.isCarbonated = isCarbonated;
        this.isDiary = isDiary;
        System.out.println("Drink instance created. Drink name: " + name);
    }

    public void drink() {
        System.out.println("Drink" + name + "is drunk");
    }

    public void heat() {
        System.out.println("Drink" + name + "is heated");
    }

    public void mix() {
        System.out.println("Drink" + name + "is mixed");
    }
}

