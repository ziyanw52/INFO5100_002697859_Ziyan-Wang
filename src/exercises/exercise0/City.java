package exercises.exercise0;

public class City {
    private String name;
    private int zipcode;
    private String country;
    private int population;
    private int area;
    private String landmark;
    private int foundedYear;
    private boolean isIndependent;

    public City(String name, int zipcode, String country, int population, int area, String landmark, int foundedYear, boolean isIndependent) {
        this.name = name;
        this.zipcode = zipcode;
        this.country = country;
        this.population = population;
        this.area = area;
        this.landmark = landmark;
        this.foundedYear = foundedYear;
        this.isIndependent = isIndependent;
        System.out.println("City instance created. City name: " + name);
    }

    public void founded() {
        System.out.println("City" + name + "is founded in" + foundedYear);
    }

    public void independent() {
        System.out.println("City" + name + "is independent");
    }

    public void findLandmark() {
        System.out.println("City" + name + "has landmark" + landmark);
    }
}

