package exercises.exercise0;

public class Clothes {
    private String name;
    private String type;
    private String size;
    private String color;
    private int price;
    private String brand;
    private boolean isForWomen;
    private String season;

    public Clothes(String name, String type, String size, String color, int price, String brand, boolean isForWomen, String season) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.color = color;
        this.price = price;
        this.brand = brand;
        this.isForWomen = isForWomen;
        this.season = season;
        System.out.println("Clothes instance created. Clothes name: " + name);
    }

    public void wear() {
        System.out.println("Clothes" + name + "is wore");
    }

    public void buy() {
        System.out.println("Clothes" + name + "is bought");
    }

    public void wash() {
        System.out.println("Clothes" + name + "is washed");
    }
}

