package exercises.exercise0;

public class Main {
    // Main Method
    public static void main(String[] args) {
        Car car1 = new Car("Red", "Sedan", 2023, 10000, true, 25000, "Gasoline", 30, "c001");
        Car car2 = new Car("White", "SUV", 2022, 20000, false, 35000, "Diesel", 25, "c002");
        Car car3 = new Car("Blue", "Hatchback", 2021, 15000, true, 20000, "Electric", 60, "c003");

        // Create at least 3 Engine instances for car1
        Car.Engine myEngine1_1 = car1.new Engine("V6", 6, 3.0, 7000, true, false, "Gasoline", 300.0, "e001");
        Car.Engine myEngine1_2 = car1.new Engine("V8", 8, 3.0, 10000, true, false, "Gasoline", 300.0, "e002");
        Car.Engine myEngine1_3 = car1.new Engine("Camry", 4, 3.0, 5000, true, true, "Gasoline", 300.0, "e003");

        // Create at least 3 Wheel instances for car2
        Car.Wheel myWheel12_1 = car2.new Wheel("Michelin", 17.0, 5, false, 75, 44, "Rubber", "Summer", "w001");
        Car.Wheel myWheel12_2 = car2.new Wheel("Goodyear", 16.5, 6, true, 90, 40, "Rubber", "All-Season", "w002");
        Car.Wheel myWheel12_3 = car2.new Wheel("Bridgestone", 17.0, 5, false, 80, 45, "Rubber", "Winter", "w003");

        Dog dogBuddy = new Dog("Buddy", 13, "Golden Retriever", 25.5, "Golden", true, true, "John");
        Dog dogMax = new Dog("Max", 2, "Labrador Retriever", 30.0, "Black", true, true, "Alice");
        Dog dogBailey = new Dog("Bailey", 4, "German Shepherd", 35.5, "Brown", false, true, "Bob");

        Cat catYoyo = new Cat("Yoyo", 2, "Persian Cat", 10.0, "white", "blue", true, "Mike");
        Cat catMimi = new Cat("Mimi", 3, "Scottish Cat", 8.2, "white and brown", "green", true, "Lucy");
        Cat catCutey = new Cat("Cutey", 1, "Ragdoll", 6.5, "white and grey", "blue", true, "Jennifer");

        Drink DrinkCoke = new Drink("Coke", "juice", 0.0, "big", 5, false, true, false);
        Drink DrinkCafe = new Drink("Cafe", "cafe", 80.0, "medium", 7, false, false, true);
        Drink DrinkOrangeJuice = new Drink("Orange Juice", "juice", 30.0, "small", 4, false, false, false);

        House House2010 = new House(95101, 1200, 2, 1, true, false, 2010, "Jackson");
        House House1956 = new House(95123, 3000, 5, 3, true, true, 1956, "Mady");
        House House2020 = new House(95131, 1800, 4, 3, true, false, 2020, "James");

        Place PlaceMuseum = new Place("museum", 91000, "PlaceOfInterest", 5, 200, true, 1900, 5);
        Place PlaceBeijing = new Place("Beijing", 25000, "City", 5, 500000, true, 1949, 24);
        Place PlaceSeafood = new Place("Seafood", 91023, "Restaurant", 4, 80, true, 2025, 8);

        Restaurant BBQ = new Restaurant("BBQ", 95231, "KoreanFood", 5, 30, true, 2021, 12);
        Restaurant RoastDuck = new Restaurant("RoastDuck", 94085, "ChineseFood", 5, 80, true, 2012, 8);
        Restaurant Sushi = new Restaurant("Sushi", 95112, "JapaneseFood", 4, 20, true, 2005, 10);

        City CityBeijing = new City("Beijing", 21000, "China", 50000, 78900, "GreatWall", 1900, true);
        City CityLosAngeles = new City("LosAngeles", 91000, "USA", 34000, 46000, "Hollywood", 1922, false);
        City CityParis = new City("Paris", 45000, "France", 4, 41000, "EiffelTower", 1931, false);

        Food FoodChips = new Food("Chips", "snack", "USA", "big", 5, false, true, false);
        Food FoodCandy = new Food("Candy", "dessert", "USA", "small", 7, false, false, false);
        Food FoodSushi = new Food("Sushi", "entree", "Japan", "small", 4, true, false, false);

        Clothes ClothesHoodie = new Clothes("Hoodie", "Outwear", "small", "white", 200, "nike", true, "sport");
        Clothes ClothesDress = new Clothes("Dress", "Bottom", "small", "pink", 120, "Maje", true, "party");
        Clothes ClothesSweat = new Clothes("Sweat", "Kintwear", "large", "black", 80, "Zara", false, "causal");
    }
}
