package exercises.exercise0;

public class Food {
    private String name;
    private String type;
    private String country;
    private String size;
    private int price;
    private boolean isVegetarian;
    private boolean isSpicy;
    private boolean isGlutenFree;

    public Food(String name, String type,String country , String size, int price, boolean isVegetarian, boolean isSpicy, boolean isGlutenFree) {
        this.name = name;
        this.type = type;
        this.country = country;
        this.size = size;
        this.price = price;
        this.isVegetarian = isVegetarian;
        this.isSpicy = isSpicy;
        this.isGlutenFree = isGlutenFree;
        System.out.println("Food instance created. Food name: " + name);
    }

    public void eat() {
        System.out.println("Food" + name + "is ate");
    }

    public void cook() {
        System.out.println("Food" + name + "is cooked");
    }

    public void expire() {
        System.out.println("Food" + name + "is expired");
    }
}

