package exercises.exercise0;

public class Place {
    private String name;
    private int zipcode;
    private String type;
    private int rating;
    private int visitors;
    private boolean hasAirConditioner;
    private int year;
    private int openHours;

    public Place(String name, int zipcode, String type, int rating, int visitors, boolean hasAirConditioner, int year, int openHours) {
        this.name = name;
        this.zipcode = zipcode;
        this.type = type;
        this.rating = rating;
        this.visitors = visitors;
        this.hasAirConditioner = hasAirConditioner;
        this.year = year;
        this.openHours = openHours;
        System.out.println("Place instance created. Place name: " + name);
    }

    public void open() {
        System.out.println("Place" + name + "is open");
    }

    public void close() {
        System.out.println("Place" + name + "is closed");
    }

    public void reserve() {
        System.out.println("Place" + name + "is reserved");
    }
}

