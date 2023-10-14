package exercises.exercise0;

public class Restaurant {
    private String name;
    private int zipcode;
    private String type;
    private int rating;
    private int partySize;
    private boolean hasAirConditioner;
    private int year;
    private int openHours;

    public Restaurant(String name, int zipcode, String type, int rating, int partySize, boolean hasAirConditioner, int year, int openHours) {
        this.name = name;
        this.zipcode = zipcode;
        this.type = type;
        this.rating = rating;
        this.partySize = partySize;
        this.hasAirConditioner = hasAirConditioner;
        this.year = year;
        this.openHours = openHours;
        System.out.println("Restaurant instance created. Restaurant name: " + name);
    }

    public void open() {
        System.out.println("Restaurant" + name + "is open");
    }

    public void close() {
        System.out.println("Restaurant" + name + "is closed");
    }

    public void reserve() {
        System.out.println("Restaurant" + name + "is reserved");
    }
}

