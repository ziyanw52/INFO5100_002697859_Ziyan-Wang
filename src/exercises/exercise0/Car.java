package exercises.exercise0;

public class Car {
    private String color;
    private String model;
    private int year;
    private int mile;
    private boolean isAuto;
    private int price;
    private String fuelType;
    private int fuelConsumption;
    private String carId;

    //Properties
    public Car(String color, String model, int year, int mile, boolean isAuto, int price, String fuelType, int fuelConsumption, String carId) {
        this.color = color;
        this.model = model;
        this.year = year;
        this.mile = mile;
        this.isAuto = isAuto;
        this.price = price;
        this.fuelType = fuelType;
        this.fuelConsumption = fuelConsumption;
        this.carId = carId;
        System.out.println("Car instance created. Car ID: " + carId);
    }

    //Methods
    public void openCar() {
        System.out.println("Open the car.");
    }

    public void startEngine() {
        System.out.println("Start the car's engine.");
    }

    public void brake() {
        System.out.println("Brake the car.");
    }

    //Nested Class1: Engine
    public class Engine {
        private String model;
        private int cylinders;
        private double displacement;
        private int maxRPM;
        private boolean turbocharged;
        private boolean hybrid;
        private String fuelType;
        private double powerOutput;
        private String engineId;

        public Engine(String model, int cylinders, double displacement, int maxRPM, boolean turbocharged, boolean hybrid, String fuelType, double powerOutput, String engineId) {
            this.model = model;
            this.cylinders = cylinders;
            this.displacement = displacement;
            this.maxRPM = maxRPM;
            this.turbocharged = turbocharged;
            this.hybrid = hybrid;
            this.fuelType = fuelType;
            this.powerOutput = powerOutput;
            this.engineId = engineId;
            System.out.println("Engine instance created. Engine ID: " + engineId);
        }

        public void start() {
            System.out.println("Engine started");
        }

        public void stop() {
            System.out.println("Engine stopped");
        }

        public void broken() {
            System.out.println("Engine is broken!");
        }
    }

    //Nested CLass2: Wheel
    public class Wheel {
        private String brand;
        private double diameter;
        private int spokes;
        private boolean tubeless;
        private int wearLevel;
        private int maxPressure;
        private String material;
        private String type;
        private String wheelId;

        public Wheel(String brand, double diameter, int spokes, boolean tubeless, int wearLevel, int maxPressure, String material, String type, String wheelId) {
            this.brand = brand;
            this.diameter = diameter;
            this.spokes = spokes;
            this.tubeless = tubeless;
            this.wearLevel = wearLevel;
            this.maxPressure = maxPressure;
            this.material = material;
            this.type = type;
            this.wheelId = wheelId;
            System.out.println("Wheel instance created. Wheel ID: " + wheelId);
        }

        public void inflate(int pressure) {
            System.out.println("Wheel inflated with pressure" + pressure);
        }

        public void rotate() {
            System.out.println("Wheel can rotate");
        }

        public void broken() {
            System.out.println("Wheels are broken!");
        }
    }
}