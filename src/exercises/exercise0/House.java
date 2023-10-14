package exercises.exercise0;

public class House {
    private int zipcode;
    private int area;
    private int numBedrooms;
    private int numBathrooms;
    private boolean hasGarage;
    private boolean hasSwimmingPool;
    private int year;
    private String ownerName;

    public House(int zipcode, int area, int numBedrooms, int numBathrooms, boolean hasGarage, boolean hasSwimmingPool, int year, String ownerName) {
        this.zipcode = zipcode;
        this.area = area;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.hasGarage = hasGarage;
        this.hasSwimmingPool = hasSwimmingPool;
        this.year = year;
        this.ownerName = ownerName;
        System.out.println("House instance created. House built year: " + year);
    }

    public void sold() {
        System.out.println("House" + year + "is sold");
    }

    public void lock() {
        System.out.println("House" + year + "is locked");
    }

    public void rent() {
        System.out.println("House" + year + "is rented");
    }
}

